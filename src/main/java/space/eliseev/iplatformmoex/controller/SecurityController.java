package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.service.SecurityIndicesService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/securities")
public class SecurityController {

    private final SecurityIndicesService securityIndicesService;
    private final SecstatsService secstatsService;


    //результаты можно получить только с 19:15 по Москве:)
    @GetMapping("engines/{engine}/markets/{market}/secstats")
    Object getSecstats(@PathVariable String engine,
                       @PathVariable String market,
                       @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                       @RequestParam(name="securities", required = false) String securities,
                       @RequestParam(name="boardid", required = false) String boardid){
        return secstatsService.getSecstats(engine,market,tradingsession,securities,boardid);

    @GetMapping("/{security}")
    Object getSecurityIndices(@PathVariable String security) {
        return securityIndicesService.getSecurityIndices(security);
    }
}
