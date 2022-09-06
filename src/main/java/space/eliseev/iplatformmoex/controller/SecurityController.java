package space.eliseev.iplatformmoex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.service.SecurityService;
import space.eliseev.iplatformmoex.service.SecstatsService;
import space.eliseev.iplatformmoex.service.SecurityIndicesService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/securities")
@Tag(name = "securities", description = "Get securities from MOEX")
public class SecurityController {
    private final SecurityService securityService;
    private final SecurityIndicesService securityIndicesService;
    private final SecstatsService secstatsService;


    @Operation(summary = "Get list of papers from MOEX",
            description = "Returns list of papers .Find by part of code with Q param",
            tags = {"securities"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of papers from MOEX")
    @GetMapping
    public Object getSecurities(@RequestParam(name = "engine", required = false) Engine engine,
                                @RequestParam(name = "market", required = false) Market market,
                                @RequestParam(name = "q", required = false) String q,
                                @RequestParam(name = "lang", required = false) String lang,
                                @RequestParam(name = "is_trading", required = false) String isTrading,
                                @RequestParam(name = "group_by", required = false) String groupBy,
                                @RequestParam(name = "group_by_filter", required = false) String groupByFilter,
                                @RequestParam(name = "limit", required = false) String limit,
                                @RequestParam(name = "start", required = false) Integer start) {
        return securityService.getSecurities(engine, market, q, lang, isTrading, groupBy, groupByFilter, limit, start);
    }

    @Operation(summary = "Get securities indexes from MOEX",
            description = "Returns list of all security index",
            tags = {"securities"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of securities indexes")
    @GetMapping("/{security}")
    public Object getSecurityIndices(@PathVariable String security) {
        return securityIndicesService.getSecurityIndices(security);
    }

    @Operation(summary = "Get results of the day from MOEX",
            description = "Returns list of results filtered by data",
            tags = {"securities"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of results")
    @GetMapping("/{security}/aggregates")
    public Object getSecurityAggregates(@PathVariable("security") String security,
                                        @RequestParam(required = false) String lang,
                                        @RequestParam(required = false) String date) {
        return securityService.getSecurityAggregates(security, date, lang);
    }

    @Operation(summary = "Get interim results of the day from MOEX",
            description = "Table filled in after end of current session 1-morning session 2-evening session 3-result of the day",
            tags = {"securities"})
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json"),
            description = "Successfully got list of results")
    @GetMapping("/engines/{engine}/markets/{market}/secstats")
    public Object getSecstats(@PathVariable Engine engine,
                              @PathVariable Market market,
                              @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                              @RequestParam(name="securities", required = false) String securities,
                              @RequestParam(name="boardid", required = false) String boardid) {
        return secstatsService.getSecstats(engine, market, tradingsession, securities, boardid);
    }
}
