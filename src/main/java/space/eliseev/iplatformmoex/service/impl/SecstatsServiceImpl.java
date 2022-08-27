package space.eliseev.iplatformmoex.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecstatsClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class SecstatsServiceImpl implements SecstatsService {
    private final UrlConfig urlConfig;
    private final SecstatsClient secstatsClient;

    @SneakyThrows
    @Override
    public Object getSecstats(Engine engine, Market market, Integer tradingsession, String securities, String boardid) {
        return secstatsClient.getSecstats(
                new URI(urlConfig.getSecstats(engine.getName(), market.getName())),tradingsession,securities,boardid);
    }
}
