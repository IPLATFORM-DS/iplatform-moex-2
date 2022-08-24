package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatformmoex.service.SecstatsService;

@RestController
@RequestMapping("/securities")
@RequiredArgsConstructor
public class SecurityController {

    private final SecstatsService secstatsService;


    //результаты можно получить только с 19:15 по Москве:)
    @GetMapping("engines/{engine}/markets/{market}/secstats")
    Object getSecstats(@PathVariable String engine,
                       @PathVariable String market,
                       @RequestParam(name="tradingsession", required = false) Integer tradingsession,
                       @RequestParam(name="securities", required = false) String securities,
                       @RequestParam(name="boardid", required = false) String boardid){
        return secstatsService.getSecstats(engine,market,tradingsession,securities,boardid);

    }
}
