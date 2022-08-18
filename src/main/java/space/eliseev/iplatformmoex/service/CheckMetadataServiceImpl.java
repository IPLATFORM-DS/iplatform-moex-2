package space.eliseev.iplatformmoex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.repository.*;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckMetadataServiceImpl implements CheckMetadataService {

    private final CheckMetadataRepository checkMetadataRepository;

    private final EngineRepository engineRepository;

    private final MarketRepository marketRepository;

    private final BoardRepository boardRepository;

    private final BoardGroupRepository boardGroupRepository;

    private final DurationRepository durationRepository;

    private final SecurityTypeRepository securityTypeRepository;

    private final SecurityGroupRepository securityGroupRepository;

    private final SecurityCollectionRepository securityCollectionRepository;

    @Override
    public boolean checkEngine(List<Engine> engines) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("Engine");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (engines.equals(engineRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkMarket(List<Market> markets) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("Market");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (markets.equals(marketRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkBoard(List<Board> boards) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("Board");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (boards.equals(boardRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkBoardGroup(List<BoardGroup> boardGroups) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("BoardGroup");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (boardGroups.equals(boardGroupRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkDuration(List<Duration> durations) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("Duration");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (durations.equals(durationRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkSecurityType(List<SecurityType> securityTypes) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("SecurityType");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (securityTypes.equals(securityTypeRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkSecurityGroup(List<SecurityGroup> securityGroups) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("SecurityGroup");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if(securityGroups.equals(securityGroupRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }

    @Override
    public boolean checkSecurityCollection(List<SecurityCollection> securityCollections) {
        CheckMetadata check = new CheckMetadata();
        check.setIndex("SecurityCollection");
        check.setTimestamp(new Timestamp(System.currentTimeMillis()));
        if (securityCollections.equals(securityCollectionRepository.findAll())) {
            check.setIsValid(true);
            checkMetadataRepository.save(check);
            return true;
        } else {
            check.setIsValid(false);
            checkMetadataRepository.save(check);
            return false;
        }
    }
}
