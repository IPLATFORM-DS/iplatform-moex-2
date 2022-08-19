package space.eliseev.iplatformmoex.service;

import space.eliseev.iplatformmoex.model.entity.*;

import java.util.List;

public interface MetadataService {
    List<Engine> getAllEngines();

    List<Market> getAllMarkets();

    List<Board> getAllBoards();

    List<BoardGroup> getAllBoardGroups();

    List<Duration> getAllDurations();

    List<SecurityType> getAllSecurityTypes();

    List<SecurityGroup> getAllSecurityGroups();

    List<SecurityCollection> getAllSecurityCollections();
}
