package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.service.SecstatsService;
import space.eliseev.iplatformmoex.service.client.SecstatsCleint;

@Service
@RequiredArgsConstructor
public class SecstatsServiceImpl implements SecstatsService {

    private final SecstatsCleint secstatsCleint;

    @Override
    public Object getSecstats(String engine, String market, Integer tradingsession, String securities,
                              String boardid) {
        return secstatsCleint.getSecstats(engine,market,tradingsession,securities,boardid);
    }
}
