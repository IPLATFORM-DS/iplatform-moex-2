package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.services.SecurityService;

/*
IPM-49 Реализовать сервис получения списка бумаг
1. Реализовать SecurityController с методом getSecurities.
2. Метод getSecurities может принимать все аргументы, перечисленные в https://iss.moex.com/iss/reference/5
3. Реализовать сервис (feign client), который будет отправлять GET запрос на https://iss.moex.com/iss/securities.
4. Запрос должен содержать все переданные параметры (если есть).
 */
/*
IPM-56 Реализовать сервис получения агрегированных итогов торгов за дату по рынкам

1. В контроллер SecurityController добавить метод getSecurityAggregates.
2. Метод getSecurityAggregates должен принимать все аргументы, описанные в https://iss.moex.com/iss/reference/214.
3. Реализовать сервис (feign client), который будет отправлять GET запрос на https://iss.moex.com/iss/securities/[security]/aggregates.
4. Запрос должен содержать все переданные параметры (если есть).
 */

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

    @GetMapping("/aggregates")
    public Object getSecurityAggregates(@RequestParam(required = false) String lang,
                                        @RequestParam(required = false) String date) {
        return securityService.getSecurityAggregates(lang, date);
    }
}
