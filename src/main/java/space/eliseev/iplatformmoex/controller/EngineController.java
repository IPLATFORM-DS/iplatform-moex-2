package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.EngineService;

@RestController
@RequestMapping(value = "/engine", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class EngineController {

    private final EngineService engineService;

    @GetMapping(value = "/getEngines")
    public Object getEngines(@RequestParam(value = "lang", required = false) String lang) {
        return engineService.getEngines(lang);
    }
}