package space.eliseev.iplatformmoex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.CheckMetadataClient;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.repository.*;
import space.eliseev.iplatformmoex.service.CheckMetadataService;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static space.eliseev.iplatformmoex.model.enumeration.Index.*;

@Service
@RequiredArgsConstructor
public class CheckMetadataServiceImpl implements CheckMetadataService {



    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final CheckMetadataRepository checkMetadataRepository;
    private final EngineRepository engineRepository;
    private final MarketRepository marketRepository;
    private final BoardRepository boardRepository;
    private final BoardGroupRepository boardGroupRepository;
    private final DurationRepository durationRepository;
    private final SecurityTypeRepository securityTypeRepository;
    private final SecurityGroupRepository securityGroupRepository;
    private final SecurityCollectionRepository securityCollectionRepository;

    private final CheckMetadataClient client;

    private final String errorMessage = "Parsing error, while parsing index";

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkEngine() {
        CheckMetadata check = new CheckMetadata();
        List<Engine> enginesFromDB = engineRepository.findAll();

        JsonNode node;
        try {
            node = objectMapper.readTree(client.getEnginesMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<Engine> fromMOEX = objectMapper.convertValue(node.findValue(ENGINES.getName()), new TypeReference<List<Engine>>() {});
        Index<Engine> comparing = new Index<>(enginesFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, ENGINES.getName()));
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkMarket() {
        CheckMetadata check = new CheckMetadata();
        List<Market> marketsFromDB = marketRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getMarketsMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<Market> fromMOEX = objectMapper.convertValue(node.findValue(MARKETS.getName()), new TypeReference<List<Market>>() {});
        Index<Market> comparing = new Index<>(marketsFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, MARKETS.getName()));
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkBoard() {
        CheckMetadata check = new CheckMetadata();
        List<Board> boardsFromDB = boardRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getBoardsMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<Board> fromMOEX = objectMapper.convertValue(node.findValue(BOARDS.getName()), new TypeReference<List<Board>>() {});
        Index<Board> comparing = new Index<>(boardsFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, BOARDS.getName()));
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkBoardGroup() {
        CheckMetadata check = new CheckMetadata();
        List<BoardGroup> boardGroupsFromDB = boardGroupRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getBoardGroupsMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<BoardGroup> fromMOEX = objectMapper.convertValue(node.findValue(BOARD_GROUPS.getName()), new TypeReference<List<BoardGroup>>() {});
        Index<BoardGroup> comparing = new Index<>(boardGroupsFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, BOARD_GROUPS.getName()));
    }

    /*
    Duration entity doesn't extend from BaseEntity and haven't field id. So there we're manually comparing two lists of Durations
     */
    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkDuration() {
        CheckMetadata check = new CheckMetadata();
        check.setTimestamp(new Date());
        check.setIndex(DURATIONS.getName());
        List<Duration> durationsFromDB = durationRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getDurationsMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<Duration> fromMOEX = objectMapper.convertValue(node.findValue(DURATIONS.getName()), new TypeReference<List<Duration>>() {});
        check.setIsValid(true);
        if (durationsFromDB.size() != fromMOEX.size()) {
            check.setIsValid(false);
        } for (int i = 0; i < durationsFromDB.size(); i++) {
            if (!durationsFromDB.get(i).getInterval().equals(fromMOEX.get(i).getInterval())) {
                check.setIsValid(false);
            }
        }
        checkMetadataRepository.save(check);
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkSecurityType() {
        CheckMetadata check = new CheckMetadata();
        List<SecurityType> securityTypesFromDB = securityTypeRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getSecurityTypesMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<SecurityType> fromMOEX = objectMapper.convertValue(node.findValue(SECURITY_TYPES.getName()), new TypeReference<List<SecurityType>>() {});
        Index<SecurityType> comparing = new Index<>(securityTypesFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, SECURITY_TYPES.getName()));
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkSecurityGroup() {
        CheckMetadata check = new CheckMetadata();
        List<SecurityGroup> securityGroupsFromDB = securityGroupRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getSecurityGroupsMOEX());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<SecurityGroup> fromMOEX = objectMapper.convertValue(node.findValue(SECURITY_GROUPS.getName()), new TypeReference<List<SecurityGroup>>() {});
        Index<SecurityGroup> comparing = new Index<>(securityGroupsFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, SECURITY_GROUPS.getName()));
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")
    public void checkSecurityCollection() {
        CheckMetadata check = new CheckMetadata();
        List<SecurityCollection> securityCollectionsFromDB = securityCollectionRepository.findAll();
        JsonNode node;
        try {
            node = objectMapper.readTree(client.getSecurityCollections());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(errorMessage);
        }
        List<SecurityCollection> fromMOEX = objectMapper.convertValue(node.findValue(SECURITY_COLLECTIONS.getName()), new TypeReference<List<SecurityCollection>>() {});
        Index<SecurityCollection> comparing = new Index<>(securityCollectionsFromDB, fromMOEX);
        checkMetadataRepository.save(comparing.validateData(check, SECURITY_COLLECTIONS.getName()));
    }

    static class Index<T extends BaseEntity> {
        List<T> fromDB;
        List<T> fromMOEX;

        public Index(List<T> fromDB, List<T> fromMOEX) {
            this.fromDB = fromDB;
            this.fromMOEX = fromMOEX;
        }

        public CheckMetadata validateData (CheckMetadata check, String index) {
            check.setTimestamp(new Date());
            check.setIndex(index);
            check.setIsValid(true);
            if (fromDB.size()!=fromMOEX.size()) {
                check.setIsValid(false);
                return check;
            }
            fromDB.sort(Comparator.comparing(T::getId));
            fromMOEX.sort(Comparator.comparing(T::getId));
            for (int i = 0; i < fromDB.size(); i++) {
                if (!fromDB.get(i).getId().equals(fromMOEX.get(i).getId())) {
                    check.setIsValid(false);
                }
            }
           return check;
        }
    }
}
