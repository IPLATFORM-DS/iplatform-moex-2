package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "moex-iss", url = "https://iss.moex.com/iss/securities")
public interface SecurityClient {

    @GetMapping(".json")
    Object getSecurities(@RequestParam(required = false) String q,
                         @RequestParam(required = false) String lang,
                         @RequestParam(required = false) String engine,
                         @RequestParam(required = false) String is_trading,
                         @RequestParam(required = false) String market,
                         @RequestParam(required = false) String group_by,
                         @RequestParam(required = false) String group_by_filter,
                         @RequestParam(required = false) String limit,
                         @RequestParam(required = false) Integer start);

    @GetMapping("/aggregates.json")
    Object getSecurityAggregates(@RequestParam(required = false) String lang,
                                 @RequestParam(required = false) String date);
}
