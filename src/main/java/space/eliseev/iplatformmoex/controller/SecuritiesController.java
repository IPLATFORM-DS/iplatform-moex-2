package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.services.SecuritiesService;

/*
IPM-49 Реализовать сервис получения списка бумаг
1. Реализовать SecurityController с методом getSecurities.
2. Метод getSecurities может принимать все аргументы, перечисленные в https://iss.moex.com/iss/reference/5
3. Реализовать сервис (feign client), который будет отправлять GET запрос на https://iss.moex.com/iss/securities.
4. Запрос должен содержать все переданные параметры (если есть).
 */
@RestController
@RequiredArgsConstructor
public class SecuritiesController {
    private final SecuritiesService securitiesService;

    @GetMapping("/securities")
    public Object getSecurities(@RequestParam(required = false) String q,
                                @RequestParam(required = false) String lang,
                                @RequestParam(required = false) String engine,
                                @RequestParam(required = false) String is_trading,
                                @RequestParam(required = false) String market,
                                @RequestParam(required = false) String group_by,
                                @RequestParam(required = false) String group_by_filter,
                                @RequestParam(required = false) Integer limit,
                                @RequestParam(required = false) Integer start) {
        return securitiesService.getSecurities(q, lang, engine, is_trading, market, group_by, group_by_filter, limit, start);
    }
}
