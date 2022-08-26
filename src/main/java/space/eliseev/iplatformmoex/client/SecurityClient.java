package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "moex-iss", url = "https://iss.moex.com/iss/securities")
public interface SecurityClient {

    @GetMapping(".json")
    Object getSecurities(@RequestParam(name = "engine", required = false) Engine engine,
                         @RequestParam(name = "market", required = false) Market market,
    Object getSecurities(@RequestParam(name = "engine", required = false) String engine,
                         @RequestParam(name = "market", required = false) String market,
                         @RequestParam(name = "q", required = false) String q,
                         @RequestParam(name = "lang", required = false) String lang,
                         @RequestParam(name = "is_trading", required = false) String isTrading,
                         @RequestParam(name = "group_by", required = false) String groupBy,
                         @RequestParam(name = "group_by_filter", required = false) String groupByFilter,
                         @RequestParam(name = "limit", required = false) String limit,
                         @RequestParam(name = "start", required = false) Integer start);

    @GetMapping("/{security}aggregates.json")
    Object getSecurityAggregates(@PathVariable("security") String security,
                                 @RequestParam(required = false) String lang,
                                 @RequestParam(required = false) String date);
}
