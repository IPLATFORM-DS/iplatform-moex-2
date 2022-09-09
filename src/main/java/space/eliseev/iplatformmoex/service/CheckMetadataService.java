package space.eliseev.iplatformmoex.service;

public interface CheckMetadataService {

    void checkEngine();

    void checkMarket();

    void checkBoard();

    void checkBoardGroup();

    void checkDuration();

    void checkSecurityType();

    void checkSecurityGroup();

    void checkSecurityCollection();
}
