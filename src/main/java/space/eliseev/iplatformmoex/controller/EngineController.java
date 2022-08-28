package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
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

    //param принимает значения engine, timetable,dailytable
    @GetMapping(value = "/getEngines/{engine}")
    public Object getEngine(@PathVariable Engine engine, @RequestParam(value = "param", required = false) String param, @RequestParam(value = "lang", required = false) String lang) {
        return engineService.getEngine(engine.getName(), param, lang);
    }
}