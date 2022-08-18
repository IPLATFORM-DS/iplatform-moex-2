package space.eliseev.iplatformmoex.service;

import space.eliseev.iplatformmoex.model.entity.*;

import java.util.List;

public interface CheckMetadataService {

    boolean checkEngine(List<Engine> engines);

    boolean checkMarket(List<Market> markets);

    boolean checkBoard(List<Board> boards);

    boolean checkBoardGroup(List<BoardGroup> boardGroups);

    boolean checkDuration(List<Duration> durations);

    boolean checkSecurityType(List<SecurityType> securityTypes);

    boolean checkSecurityGroup(List<SecurityGroup> securityGroups);

    boolean checkSecurityCollection(List<SecurityCollection> securityCollections);
}
