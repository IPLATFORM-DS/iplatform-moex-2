package space.eliseev.iplatformmoex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.repository.*;

import java.util.List;

@AllArgsConstructor
@Service
public class MetadataServiceImpl implements MetadataService {
    private final EngineMetadataRepository engineMetadataRepository;
    private final MarketMetadataRepository marketMetadataRepository;
    private final BoardMetadataRepository boardMetadataRepository;
    private final BoardGroupMetadataRepository boardGroupMetadataRepository;
    private final DurationMetadataRepository durationMetadataRepository;
    private final SecurityTypeMetadataRepository securityTypeMetadataRepository;
    private final SecurityGroupMetadataRepository securityGroupMetadataRepository;
    private final SecurityCollectionMetadataRepository securityCollectionMetadataRepository;


    @Override
    public List<Engine> getAllEngines() {
        return engineMetadataRepository.findAll();
    }

    @Override
    public List<Market> getAllMarkets() {
        return marketMetadataRepository.findAll();
    }

    @Override
    public List<Board> getAllBoards() {
        return boardMetadataRepository.findAll();
    }

    @Override
    public List<BoardGroup> getAllBoardGroups() {
        return boardGroupMetadataRepository.findAll();
    }

    @Override
    public List<Duration> getAllDurations() {
        return durationMetadataRepository.findAll();
    }

    @Override
    public List<SecurityType> getAllSecurityTypes() {
        return securityTypeMetadataRepository.findAll();
    }

    @Override
    public List<SecurityGroup> getAllSecurityGroups() {
        return securityGroupMetadataRepository.findAll();
    }

    @Override
    public List<SecurityCollection> getAllSecurityCollections() {
        return securityCollectionMetadataRepository.findAll();
    }
}
