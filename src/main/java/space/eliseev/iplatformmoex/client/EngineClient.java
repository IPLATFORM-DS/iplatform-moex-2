package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import java.net.URI;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;

import java.util.List;

@FeignClient(value = "engine", url = "engine")
public interface EngineClient {
    @GetMapping
    List<EngineJsonDto> getEngines(URI enginesUri,
                                   @RequestParam(value = "lang", required = false) String lang);

    String ENGINES_URL = "https://iss.moex.com/iss/engines";

    @GetMapping(value = ".json?iss.meta=off&iss.only=data&iss.json=extended", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EngineJsonDto> getEngines(@RequestParam(value = "lang", required = false) String lang);

    @GetMapping(value = "/{engine}.json?iss.meta=off&iss.json=extended&iss.only={param}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SingleEngineJsonDto> getEngine(@PathVariable String engine, @PathVariable(required = false) String param, @RequestParam(value = "lang", required = false) String lang);
}
