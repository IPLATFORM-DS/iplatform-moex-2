package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.service.SecstatsService;
import space.eliseev.iplatformmoex.service.SecurityIndicesService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/securities")
public class SecurityController {

    private final SecurityIndicesService securityIndicesService;
    private final SecstatsService secstatsService;


    @GetMapping("engines/{engine}/markets/{market}/secstats")
    Object getSecstats(@PathVariable Engine engine,
                       @PathVariable Market market,
                       @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                       @RequestParam(name="securities", required = false) String securities,
                       @RequestParam(name="boardid", required = false) String boardid) {
        return secstatsService.getSecstats(engine.getName(), market.getName(), tradingsession, securities, boardid);
    }

    @GetMapping("/{security}")
    Object getSecurityIndices(@PathVariable String security) {
        return securityIndicesService.getSecurityIndices(security);
    }
}
