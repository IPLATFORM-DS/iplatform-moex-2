package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.service.CheckMetadataService;

import java.util.List;

@RestController
@RequestMapping(value = "/checkMetadata", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class CheckMetadataController {

    private final CheckMetadataService checkMetadataService;

    private final MetadataController metadataController;

    /*
        (cron) this means that this method will be called every day at 9 am
        google: cron expressions
     */
    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/engines")
    public ResponseEntity<Boolean> getCheckEngines() {
        List<Engine> engines = (List<Engine>) metadataController.getEngines();
        return new ResponseEntity<>(checkMetadataService.checkEngine(engines), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/markets")
    public ResponseEntity<Boolean> getCheckMarkets() {
        List<Market> markets = (List<Market>) metadataController.getMarkets();
        return new ResponseEntity<>(checkMetadataService.checkMarket(markets), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/boards")
    public ResponseEntity<Boolean> getCheckBoards() {
        List<Board> boards = (List<Board>) metadataController.getBoards();
        return new ResponseEntity<>(checkMetadataService.checkBoard(boards), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/boardgroups")
    public ResponseEntity<Boolean> getCheckBoardGroups() {
        List<BoardGroup> boardGroups = (List<BoardGroup>) metadataController.getBoardGroups();
        return new ResponseEntity<>(checkMetadataService.checkBoardGroup(boardGroups), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/durations")
    public ResponseEntity<Boolean> getCheckDurations() {
        List<Duration> durations = (List<Duration>) metadataController.getDurations();
        return new ResponseEntity<>(checkMetadataService.checkDuration(durations),HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/securitytypes")
    public ResponseEntity<Boolean> getCheckSecurityTypes() {
        List<SecurityType> securityTypes = (List<SecurityType>) metadataController.getSecurityTypes();
        return new ResponseEntity<>(checkMetadataService.checkSecurityType(securityTypes), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/securitygroups")
    public ResponseEntity<Boolean> getCheckSecurityGroups() {
        List<SecurityGroup> securityGroups = (List<SecurityGroup>) metadataController.getSecurityGroups();
        return new ResponseEntity<>(checkMetadataService.checkSecurityGroup(securityGroups), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 * * *")
    @GetMapping("/securitycollections")
    public ResponseEntity<Boolean> getCheckSecurityCollections() {
        List<SecurityCollection> securityCollections = (List<SecurityCollection>) metadataController.getSecurityCollections();
        return new ResponseEntity<>(checkMetadataService.checkSecurityCollection(securityCollections), HttpStatus.OK);
    }
}
