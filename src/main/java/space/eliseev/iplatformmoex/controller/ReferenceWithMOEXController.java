package space.eliseev.iplatformmoex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Index;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;
import space.eliseev.iplatformmoex.service.factories.ReferenceWithMOEXFactory;

@RestController
@RequestMapping("/index")
@RequiredArgsConstructor
@Tag(name = "ref", description = "Reference data from MOEX")
public class ReferenceWithMOEXController {


    private final ReferenceWithMOEXService service;
    private final ReferenceWithMOEXFactory factory;

    @Operation(summary = "Get reference data from MOEX", description = "Returns reference data, " +
            "Index param can be used as a filter to return data by category(\"engines\", \"markets\" etc)",
            tags = {"ref"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ReferenceWithMOEXJsonDto.class))),
    description = "Successful operation"),
    @ApiResponse(responseCode = "400", description = "Invalid parameter supplied",
            content = @Content)
})
    @GetMapping
    public Object getReferenceWithMOEX(
            @RequestParam(value = "param", required = false) Index param,
            @RequestParam(value = "lang", required = false) String lang,
            @RequestParam(value = "engine", required = false) Engine engine,
            @RequestParam(value = "is_traded", required = false) Integer isTraded,
            @RequestParam(value = "hide_inactive", required = false) Integer hideInactive,
            @RequestParam(value = "securitygroups", required = false) String securitygroups,
            @RequestParam(value = "trade_engine", required = false) String tradeEngine
    ) {
        return factory.showIndexData((param == null) ? null : param.getName(),
                service.getReferenceWithMOEX(param, lang, engine, isTraded,
                        hideInactive, securitygroups, tradeEngine));
    }


}
