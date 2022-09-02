package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "moex", url = "securities")
public interface SecurityClient {
    @GetMapping
    Object getSecurities(URI securitiesUri,
                         @RequestParam(name = "engine", required = false) String engine,
                         @RequestParam(name = "market", required = false) String market,
                         @RequestParam(name = "q", required = false) String q,
                         @RequestParam(name = "lang", required = false) String lang,
                         @RequestParam(name = "is_trading", required = false) String isTrading,
                         @RequestParam(name = "group_by", required = false) String groupBy,
                         @RequestParam(name = "group_by_filter", required = false) String groupByFilter,
                         @RequestParam(name = "limit", required = false) String limit,
                         @RequestParam(name = "start", required = false) Integer start);

    @GetMapping
    Object getSecurityAggregates(URI aggregatesUri,
                                 @RequestParam(required = false) String lang,
                                 @RequestParam(required = false) String date);

    @GetMapping
    Object getSecurityIndices(URI indicesUri);
}
