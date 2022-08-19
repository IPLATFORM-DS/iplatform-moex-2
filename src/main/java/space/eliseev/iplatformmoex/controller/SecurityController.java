package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Object getSecurities(@RequestParam(required = false) String q,
                                @RequestParam(required = false) String lang,
                                @RequestParam(required = false) String engine,
                                @RequestParam(required = false) String is_trading,
                                @RequestParam(required = false) String market,
                                @RequestParam(required = false) String group_by,
                                @RequestParam(required = false) String group_by_filter,
                                @RequestParam(required = false) String limit,
                                @RequestParam(required = false) Integer start) {
        return securityService.getSecurities(q, lang, engine, is_trading, market, group_by, group_by_filter, limit, start);
    }

    @GetMapping("/aggregates")
    public Object getSecurityAggregates(@RequestParam(required = false) String lang,
                                        @RequestParam(required = false) String date) {
        return securityService.getSecurityAggregates(lang, date);
    }
}
