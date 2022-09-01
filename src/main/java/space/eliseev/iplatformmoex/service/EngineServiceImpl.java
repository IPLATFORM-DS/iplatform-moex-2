package space.eliseev.iplatformmoex.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.EngineClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.EngineParam;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {
    private final UrlConfig urlConfig;
    private final EngineClient engineClient;

    @SneakyThrows
    @Override
    public Object getEngines(String lang) {
        List<EngineJsonDto> list = engineClient.getEngines(
                new URI(urlConfig.getEngines()), lang);
        return list.get(1).getEngines();
    }

    @Override
    public List<SingleEngineJsonDto> getEngine(Engine engine, EngineParam param, String lang) throws URISyntaxException {
        if(param==null){
            return engineClient.getEngine(new URI(urlConfig.getEngine(engine.getName(), null)), lang);
        }
        return engineClient.getEngine(new URI(urlConfig.getEngine(engine.getName(), param.getName())), lang);
    }
}

