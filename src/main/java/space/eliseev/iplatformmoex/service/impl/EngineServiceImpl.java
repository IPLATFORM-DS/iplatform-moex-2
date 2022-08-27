package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import space.eliseev.iplatformmoex.model.entity.Engine;
import space.eliseev.iplatformmoex.service.EngineService;
import space.eliseev.iplatformmoex.client.EngineClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineClient engineClient;

    @Override
    public Object getEngines(String lang) {
        List<EngineJsonDto> list = engineClient.getEngines(lang);
        List<Engine> engines = list.get(1).getEngines();
        return engines;
    }
}
