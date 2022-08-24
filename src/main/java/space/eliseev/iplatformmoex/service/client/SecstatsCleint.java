package space.eliseev.iplatformmoex.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import static space.eliseev.iplatformmoex.service.client.SecstatsCleint.SECSTATS_URL;

@FeignClient(value = "secstats", url = SECSTATS_URL)
public interface SecstatsCleint {
    String SECSTATS_URL = "https://iss.moex.com/iss/engines";
    @GetMapping(value = "/{engine}/markets/{market}/secstats.json?iss.meta=off&iss.only=engines&iss.json=extended",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Object getSecstats(@PathVariable String engine,
                       @PathVariable String market,
                       @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                       @RequestParam(name="securities", required = false) String securities,
                       @RequestParam(name="boardid", required = false) String boardid);
}

