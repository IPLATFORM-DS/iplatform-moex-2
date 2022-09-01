package space.eliseev.iplatformmoex.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
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


    @GetMapping
    List<SingleEngineJsonDto> getEngine(URI engineUri, @RequestParam(value = "lang", required = false) String lang);
}
