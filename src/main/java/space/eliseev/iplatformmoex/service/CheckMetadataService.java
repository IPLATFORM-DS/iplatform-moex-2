package space.eliseev.iplatformmoex.service;

import org.springframework.stereotype.Service;

@Service
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
