package space.eliseev.iplatformmoex.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.entity.Engine;

import java.util.List;

@FeignClient(value = "engine",url="https://iss.moex.com/iss/")
public interface EngineService {

    @GetMapping(value = "/engines?iss.meta=off&iss.only=engines", produces= MediaType.APPLICATION_JSON_VALUE)
    Object getEngines(@RequestParam(value = "lang", required = false)String lang);
}
