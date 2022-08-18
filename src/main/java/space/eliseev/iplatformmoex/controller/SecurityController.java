package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.services.SecurityService;

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
                                @RequestParam(required = false) Integer limit,
                                @RequestParam(required = false) Integer start) {
        return securityService.getSecurities(q, lang, engine, is_trading, market, group_by, group_by_filter, limit, start);
    }

}
