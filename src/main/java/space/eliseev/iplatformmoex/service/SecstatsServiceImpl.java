package space.eliseev.iplatformmoex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecstatsCleint;

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
