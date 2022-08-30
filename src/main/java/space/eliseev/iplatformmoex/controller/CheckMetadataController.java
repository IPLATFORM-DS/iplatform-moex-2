package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.CheckMetadataService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checkMetadata")
public class CheckMetadataController {

    private final CheckMetadataService service;

    @GetMapping("/engines")
    public void checkEngines() {
        service.checkEngine();
    }

    @GetMapping("/markets")
    public void checkMarkets() {
        service.checkMarket();
    }

    @GetMapping("/boards")
    public void checkBoards() {
        service.checkBoard();
    }

    @GetMapping("/boardgroups")
    public void checkBoardGroups() {
        service.checkBoardGroup();
    }

    @GetMapping("/durations")
    public void checkDurations() {
        service.checkDuration();
    }

    @GetMapping("/securitytypes")
    public void checkSecurityTypes() {
        service.checkSecurityType();
    }

    @GetMapping("/securitygroups")
    public void checkSecurityGroups() {
        service.checkSecurityGroup();
    }

    @GetMapping("/securitycollections")
    public void checkSecurityCollections() {
        service.checkSecurityCollection();
    }
}
