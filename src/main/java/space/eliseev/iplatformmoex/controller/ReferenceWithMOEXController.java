package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Index;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;

import java.util.List;

@RestController
@RequestMapping("/index")
@RequiredArgsConstructor
public class ReferenceWithMOEXController {


    private final ReferenceWithMOEXService service;

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
        return service.getReferenceWithMOEX(param, lang, engine, isTraded, hideInactive, securitygroups, tradeEngine);

    }


}
