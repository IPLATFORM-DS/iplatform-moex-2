package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;

import java.util.List;

import static space.eliseev.iplatformmoex.client.EngineClient.ENGINES_URL;

@FeignClient(value = "engine", url = ENGINES_URL)
public interface EngineClient {

    String ENGINES_URL = "https://iss.moex.com/iss/engines";

    @GetMapping(value = ".json?iss.meta=off&iss.only=data&iss.json=extended", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EngineJsonDto> getEngines(@RequestParam(value = "lang", required = false) String lang);

    @GetMapping(value = "/{engine}.json?iss.meta=off&iss.json=extended&iss.only={param}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SingleEngineJsonDto> getEngine(@PathVariable String engine, @PathVariable(required = false) String param, @RequestParam(value = "lang", required = false) String lang);
}
