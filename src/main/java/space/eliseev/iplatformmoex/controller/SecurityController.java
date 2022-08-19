package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.services.SecurityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/securities")
public class SecurityController {
    private final SecurityService securityService;

    @GetMapping
    public Object getSecurities(@RequestParam(name = "engine", required = false) String e,
                                @RequestParam(name = "market", required = false) String m,
                                @RequestParam(name = "q", required = false) String q,
                                @RequestParam(name = "lang", required = false) String lang,
                                @RequestParam(name = "is_trading", required = false) String isTrading,
                                @RequestParam(name = "group_by", required = false) String groupBy,
                                @RequestParam(name = "group_by_filter", required = false) String groupByFilter,
                                @RequestParam(name = "limit", required = false) String limit,
                                @RequestParam(name = "start", required = false) Integer start) {
        Engine engine = (e == null) ? null : Engine.valueOf(e.toUpperCase());
        Market market = (m == null) ? null : Market.valueOf(m.toUpperCase());
        return securityService.getSecurities(engine, market, q, lang, isTrading, groupBy, groupByFilter, limit, start);
    }

}
