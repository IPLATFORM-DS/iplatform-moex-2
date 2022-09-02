package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "checkMetadataClient", url = CheckMetadataClient.CHECK_URL)
public interface CheckMetadataClient {
    String CHECK_URL = "https://iss.moex.com/iss/index";

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=engines")
    String getEnginesMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=markets")
    String getMarketsMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=boards")
    String getBoardsMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=boardgroups")
    String getBoardGroupsMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=durations")
    String getDurationsMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=securitytypes")
    String getSecurityTypesMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=securitygroups")
    String getSecurityGroupsMOEX();

    @GetMapping(".json?iss.meta=off&iss.json=extended&iss.only=securitycollections")
    String getSecurityCollections();
}
