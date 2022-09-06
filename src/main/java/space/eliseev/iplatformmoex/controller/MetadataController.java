package space.eliseev.iplatformmoex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "metadata", description = "Get metadata from MOEX")
public class MetadataController {
    private final MetadataService metadataService;

    @Operation(summary = "Get engines from MOEX",
               description = "Returns list of all engines",
               tags = {"metadata"})
    @ApiResponse(responseCode = "200",
                 content = @Content(mediaType = "application/json"),
                 description = "Successfully got list of engines")
    @GetMapping("/engines")
    public ResponseEntity<List<Engine>> getEngines() {
        return new ResponseEntity<>(metadataService.getAllEngines(), HttpStatus.OK);
    }

    @Operation(summary = "Get markets from MOEX",
            description = "Returns list of all markets",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of markets")
    @GetMapping("/markets")
    public ResponseEntity<List<Market>> getMarkets() {
        return new ResponseEntity<>(metadataService.getAllMarkets(), HttpStatus.OK);
    }

    @Operation(summary = "Get boards from MOEX",
            description = "Returns list of all boards",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of boards")
    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getBoards() {
        return new ResponseEntity<>(metadataService.getAllBoards(), HttpStatus.OK);
    }

    @Operation(summary = "Get board groups from MOEX",
            description = "Returns list of all board groups",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of board groups")
    @GetMapping("/boardgroups")
    public ResponseEntity<List<BoardGroup>> getBoardGroups() {
        return new ResponseEntity<>(metadataService.getAllBoardGroups(), HttpStatus.OK);
    }

    @Operation(summary = "Get duration options from MOEX",
            description = "Returns list of all duration options",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of duration options")
    @GetMapping("/durations")
    public ResponseEntity<List<Duration>> getDurations() {
        return new ResponseEntity<>(metadataService.getAllDurations(), HttpStatus.OK);
    }

    @Operation(summary = "Get security types from MOEX",
            description = "Returns list of all security types",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of security types")
    @GetMapping("/securitytypes")
    public ResponseEntity<List<SecurityType>> getSecurityTypes() {
        return new ResponseEntity<>(metadataService.getAllSecurityTypes(), HttpStatus.OK);
    }

    @Operation(summary = "Get security groups from MOEX",
            description = "Returns list of all security groups",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of security groups")
    @GetMapping("/securitygroups")
    public ResponseEntity<List<SecurityGroup>> getSecurityGroups() {
        return new ResponseEntity<>(metadataService.getAllSecurityGroups(), HttpStatus.OK);
    }

    @Operation(summary = "Get all security collections from MOEX",
            description = "Returns list of all security collections",
            tags = {"metadata"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of security collections")
    @GetMapping("/securitycollections")
    public ResponseEntity<List<SecurityCollection>> getSecurityCollections() {
        return new ResponseEntity<>(metadataService.getAllSecurityCollections(), HttpStatus.OK);
    }

}
