package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.EngineService;


import java.util.*;

@RestController
public class EngineController {


    @Autowired
    private EngineService engineService;

    @GetMapping(value = "/engine", produces= MediaType.APPLICATION_JSON_VALUE)
    public Object getEngine(@RequestParam(value = "lang", required = false)String lang){
        return engineService.getEngines(lang);
    }
}
