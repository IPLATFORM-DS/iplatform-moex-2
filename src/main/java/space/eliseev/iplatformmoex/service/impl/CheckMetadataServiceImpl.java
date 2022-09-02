package space.eliseev.iplatformmoex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.CheckMetadataClient;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.model.enumeration.Metadata;
import space.eliseev.iplatformmoex.repository.*;
import space.eliseev.iplatformmoex.service.CheckMetadataService;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static space.eliseev.iplatformmoex.model.enumeration.Metadata.*;

@Service
@RequiredArgsConstructor
@Slf4j
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

    private final Map<Metadata, JpaRepository> repositories;
    @PostConstruct
    private void createMapRepositories () {
        repositories.put(ENGINES, engineRepository);
        repositories.put(MARKETS, marketRepository);
        repositories.put(BOARDS, boardRepository);
        repositories.put(BOARD_GROUPS, boardGroupRepository);
        repositories.put(DURATIONS, durationRepository);
        repositories.put(SECURITY_TYPES, securityTypeRepository);
        repositories.put(SECURITY_GROUPS, securityGroupRepository);
        repositories.put(SECURITY_COLLECTIONS, securityCollectionRepository);
    }

    @Override
    public void checkEngine() {
        JsonNode node = prepareJsonToConvert(client.getEnginesMOEX(), ENGINES);
        List<Engine> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<Engine>>() {});
        Index<Engine> comparing = new Index<>((List<Engine>) getListFromDB(ENGINES), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(ENGINES));
    }

    @Override
    public void checkMarket() {
        JsonNode node = prepareJsonToConvert(client.getMarketsMOEX(), MARKETS);
        List<Market> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<Market>>() {});
        Index<Market> comparing = new Index<>((List<Market>) getListFromDB(MARKETS), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(MARKETS));
    }

    @Override
    public void checkBoard() {
        JsonNode node = prepareJsonToConvert(client.getBoardsMOEX(), BOARDS);
        List<Board> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<Board>>() {});
        Index<Board> comparing = new Index<>((List<Board>) getListFromDB((BOARDS)), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(BOARDS));
    }

    @Override
    public void checkBoardGroup() {
        JsonNode node = prepareJsonToConvert(client.getBoardGroupsMOEX(), BOARD_GROUPS);
        List<BoardGroup> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<BoardGroup>>() {});
        Index<BoardGroup> comparing = new Index<>((List<BoardGroup>) getListFromDB(BOARD_GROUPS), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(BOARD_GROUPS));
    }

    /*
    Duration entity doesn't extend from BaseEntity and haven't field id. So there we're manually comparing two lists of Durations
     */
    @Override
    public void checkDuration() {
        CheckMetadata check = new CheckMetadata();
        check.setTimestamp(new Date());
        check.setIndex(DURATIONS.getName());
        List<Duration> durationsFromDB = durationRepository.findAll();
        JsonNode node = null;
        try {
            node = objectMapper.readTree(client.getDurationsMOEX());
        } catch (JsonProcessingException e) {
            log.warn(errorMessage);
        }
        if (node == null) {
            log.warn("Client didn't return a JSON");
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
    public void checkSecurityType() {
        JsonNode node = prepareJsonToConvert(client.getSecurityTypesMOEX(), SECURITY_TYPES);

        List<SecurityType> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<SecurityType>>() {});
        Index<SecurityType> comparing = new Index<>((List<SecurityType>) getListFromDB(SECURITY_TYPES), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(SECURITY_TYPES));
    }

    @Override
    public void checkSecurityGroup() {
        JsonNode node = prepareJsonToConvert(client.getSecurityGroupsMOEX(), SECURITY_GROUPS);
        List<SecurityGroup> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<SecurityGroup>>() {});
        Index<SecurityGroup> comparing = new Index<>((List<SecurityGroup>) getListFromDB(SECURITY_GROUPS), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(SECURITY_GROUPS));
    }

    @Override
    public void checkSecurityCollection() {
        JsonNode node = prepareJsonToConvert(client.getSecurityCollections(), SECURITY_COLLECTIONS);
        List<SecurityCollection> fromMOEX = objectMapper.convertValue(node, new TypeReference<List<SecurityCollection>>() {});
        Index<SecurityCollection> comparing = new Index<>((List<SecurityCollection>) getListFromDB(SECURITY_COLLECTIONS), fromMOEX);
        checkMetadataRepository.save(comparing.validateData(SECURITY_COLLECTIONS));
    }

    /*
        Generic class to reduce boilerplate and improve readability (I hope so)
     */

    static class Index<T extends BaseEntity> {
        List<T> fromDB;
        List<T> fromMOEX;

        public Index(List<T> fromDB, List<T> fromMOEX) {
            this.fromDB = fromDB;
            this.fromMOEX = fromMOEX;
        }

        public CheckMetadata validateData (Metadata enumeration) {
            CheckMetadata check = new CheckMetadata();
            check.setTimestamp(new Date());
            check.setIndex(enumeration.getName());
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

    /*
        Find required repo in map
     */
    private List<?> getListFromDB(Metadata enumeration) {
        return (List<?>) repositories.get(enumeration).findAll();
    }

    /*
       Take JSON, turn it to tree and find required Objects there
     */
    private JsonNode prepareJsonToConvert (String json, Metadata enumeration) {
        JsonNode node = null;
        try {
           node = objectMapper.readTree(json);
        }  catch (JsonProcessingException  e) {
            log.warn(errorMessage);
        }
        return node != null ? node.findValue(enumeration.getName()) : null;
    }

}
