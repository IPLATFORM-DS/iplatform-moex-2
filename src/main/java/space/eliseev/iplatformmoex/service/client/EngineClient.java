package space.eliseev.iplatformmoex.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static space.eliseev.iplatformmoex.service.client.EngineClient.ENGINES_URL;

@FeignClient(value = "engine", url = ENGINES_URL)
public interface EngineClient {

    String ENGINES_URL = "https://iss.moex.com/iss/engines";

    @GetMapping(value = "?iss.meta=off&iss.only=engines", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getEngines(@RequestParam(value = "lang", required = false) String lang);
}