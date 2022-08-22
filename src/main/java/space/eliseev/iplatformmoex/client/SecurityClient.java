package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;

@FeignClient(value = "moex-iss", url = "https://iss.moex.com/iss/securities")
public interface SecurityClient {

    @GetMapping(".json")
    Object getSecurities(@RequestParam(required = false) Engine engine,
                         @RequestParam(required = false) Market market,
                         @RequestParam(required = false) String q,
                         @RequestParam(required = false) String lang,
                         @RequestParam(required = false) String is_trading,
                         @RequestParam(required = false) String group_by,
                         @RequestParam(required = false) String group_by_filter,
                         @RequestParam(required = false) String limit,
                         @RequestParam(required = false) Integer start);

    @GetMapping("/{security}aggregates.json")
    Object getSecurityAggregates(@PathVariable("security") String security,
                                 @RequestParam(required = false) String lang,
                                 @RequestParam(required = false) String date);
}
