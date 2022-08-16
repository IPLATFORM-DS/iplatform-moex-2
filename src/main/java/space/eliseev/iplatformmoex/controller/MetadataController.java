package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.entity.*;
import space.eliseev.iplatformmoex.service.MetadataService;

import java.util.List;

@RestController
@RequestMapping(value = "/metadata", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class MetadataController {
    private final MetadataService metadataService;


    @GetMapping("/engines")
    public ResponseEntity<List<Engine>> getEngines() {
        return new ResponseEntity<>(metadataService.getAllEngines(), HttpStatus.OK);
    }

    @GetMapping("/markets")
    public ResponseEntity<List<Market>> getMarkets() {
        return new ResponseEntity<>(metadataService.getAllMarkets(), HttpStatus.OK);
    }

    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getBoards() {
        return new ResponseEntity<>(metadataService.getAllBoards(), HttpStatus.OK);
    }

    @GetMapping("/boardgroups")
    public ResponseEntity<List<BoardGroup>> getBoardGroups() {
        return new ResponseEntity<>(metadataService.getAllBoardGroups(), HttpStatus.OK);
    }

    @GetMapping("/durations")
    public ResponseEntity<List<Duration>> getDurations() {
        return new ResponseEntity<>(metadataService.getAllDurations(), HttpStatus.OK);
    }

    @GetMapping("/securitytypes")
    public ResponseEntity<List<SecurityType>> getSecurityTypes() {
        return new ResponseEntity<>(metadataService.getAllSecurityTypes(), HttpStatus.OK);
    }

    @GetMapping("/securitygroups")
    public ResponseEntity<List<SecurityGroup>> getSecurityGroups() {
        return new ResponseEntity<>(metadataService.getAllSecurityGroups(), HttpStatus.OK);
    }

    @GetMapping("/securitycollections")
    public ResponseEntity<List<SecurityCollection>> getSecurityCollections() {
        return new ResponseEntity<>(metadataService.getAllSecurityCollections(), HttpStatus.OK);
    }

}
