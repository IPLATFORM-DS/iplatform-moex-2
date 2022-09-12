package space.eliseev.iplatformmoex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.EngineParam;
import space.eliseev.iplatformmoex.service.EngineService;
import space.eliseev.iplatformmoex.service.factories.EngineFactory;

@RestController
@RequestMapping(value = "/engine", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
@Tag(name = "engine", description = "The Engine API")
public class EngineController {

    private final EngineService engineService;

    private final EngineFactory factory;
    @Operation(summary = "Get all engines", description = "It can be used to get the list of all engines",
            tags = {"engine"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = EngineJsonDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getEngines")
    public Object getEngines(@RequestParam(value = "lang", required = false) String lang) {
        return engineService.getEngines(lang);
    }

    @Operation(summary = "Get engine by name", description = "It returns one engine with the name specified",
            tags = {"engine"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = SingleEngineJsonDto.class))),
                    description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameter supplied",
                    content = @Content)
    })
    @GetMapping(value = "/getEngines/{engine}")
    public Object getEngine(@PathVariable Engine engine,
                            @RequestParam(value = "param", required = false) EngineParam param,
                            @RequestParam(value = "lang", required = false) String lang){
        return factory.showEngineData((param == null) ? null : param.getName(), engineService.getEngine(engine, param, lang));
    }
}
