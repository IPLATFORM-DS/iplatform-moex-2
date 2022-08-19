package space.eliseev.iplatformmoex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetadataServiceImpl implements MetadataService {
    private final EngineRepository engineRepository;
    private final MarketRepository marketRepository;
    private final BoardRepository boardRepository;
    private final BoardGroupRepository boardGroupRepository;
    private final DurationRepository durationRepository;
    private final SecurityTypeRepository securityTypeRepository;
    private final SecurityGroupRepository securityGroupRepository;
    private final SecurityCollectionRepository securityCollectionRepository;


    @Override
    public List<Engine> getAllEngines() {
        return engineRepository.findAll();
    }

    @Override
    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public List<BoardGroup> getAllBoardGroups() {
        return boardGroupRepository.findAll();
    }

    @Override
    public List<Duration> getAllDurations() {
        return durationRepository.findAll();
    }

    @Override
    public List<SecurityType> getAllSecurityTypes() {
        return securityTypeRepository.findAll();
    }

    @Override
    public List<SecurityGroup> getAllSecurityGroups() {
        return securityGroupRepository.findAll();
    }

    @Override
    public List<SecurityCollection> getAllSecurityCollections() {
        return securityCollectionRepository.findAll();
    }
}
