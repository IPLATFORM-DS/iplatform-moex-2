package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.client.EngineClient;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import space.eliseev.iplatformmoex.client.EngineClient;
import space.eliseev.iplatformmoex.service.EngineService;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.entity.Engine;

import java.net.URI;
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
    public Object getEngine(String engine, String param, String lang) {
        List<SingleEngineJsonDto> list=engineClient.getEngine(engine, param, lang);
        if(param==null){
            return list;
        }else if(param.equals("engine")){
            return list.get(1).getEngine();
        }else if(param.equals("timetable")){
            return list.get(1).getTimetable();
        }else if(param.equals("dailytable")){
            return list.get(1).getDailytable();
        }
        return list;
    }
}
