package space.eliseev.iplatformmoex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.CheckMetadataService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checkMetadata")
@Tag(name = "check", description = "Checking if values match: in the DB and in the MOEX")
public class CheckMetadataController {

    private final CheckMetadataService service;

    @Operation(summary = "Checking if values match for engines",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for engines")
    @GetMapping("/engines")
    public void checkEngines() {
        service.checkEngine();
    }

    @Operation(summary = "Checking if values match for markets",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for markets")
    @GetMapping("/markets")
    public void checkMarkets() {
        service.checkMarket();
    }

    @Operation(summary = "Checking if values match for boards",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for boards")
    @GetMapping("/boards")
    public void checkBoards() {
        service.checkBoard();
    }

    @Operation(summary = "Checking if values match for board groups",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for board groups")
    @GetMapping("/boardgroups")
    public void checkBoardGroups() {
        service.checkBoardGroup();
    }

    @Operation(summary = "Checking if values match for duration options",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for duration options")
    @GetMapping("/durations")
    public void checkDurations() {
        service.checkDuration();
    }

    @Operation(summary = "Checking if values match for security types",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for security types")
    @GetMapping("/securitytypes")
    public void checkSecurityTypes() {
        service.checkSecurityType();
    }

    @Operation(summary = "Checking if values match for security groups",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for security groups")
    @GetMapping("/securitygroups")
    public void checkSecurityGroups() {
        service.checkSecurityGroup();
    }

    @Operation(summary = "Checking if values match for security collections",
            description = "Runs check to see if the resulting value matches in the database and in the MOEX",
            tags = {"check"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully compared matching values for security collections")
    @GetMapping("/securitycollections")
    public void checkSecurityCollections() {
        service.checkSecurityCollection();
    }
}
