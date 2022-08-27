package space.eliseev.iplatformmoex.controller;

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
public class SecurityController {
    private final SecurityService securityService;
    private final SecurityIndicesService securityIndicesService;
    private final SecstatsService secstatsService;


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

    @GetMapping("/{security}")
    public Object getSecurityIndices(@PathVariable String security) {
        return securityIndicesService.getSecurityIndices(security);
    }

    @GetMapping("/{security}/aggregates")
    public Object getSecurityAggregates(@PathVariable("security") String security,
                                        @RequestParam(required = false) String lang,
                                        @RequestParam(required = false) String date) {
        return securityService.getSecurityAggregates(security, date, lang);
    }

    @GetMapping("/engines/{engine}/markets/{market}/secstats")
    public Object getSecstats(@PathVariable Engine engine,
                              @PathVariable Market market,
                              @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                              @RequestParam(name="securities", required = false) String securities,
                              @RequestParam(name="boardid", required = false) String boardid) {
        return secstatsService.getSecstats(engine.getName(), market.getName(), tradingsession, securities, boardid);
    }
}
