package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.mapper.EngineMapper;
import space.eliseev.iplatformmoex.model.dto.engine.EngineDto;
import space.eliseev.iplatformmoex.model.dto.engine.EngineJsonDto;
import space.eliseev.iplatformmoex.model.entity.Engine;
import space.eliseev.iplatformmoex.service.EngineService;
import space.eliseev.iplatformmoex.service.client.EngineClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineClient engineClient;
    private final EngineMapper engineMapper;

    @Override
    public Object getEngines(String lang) {
        List<EngineJsonDto> list = engineClient.getEngines(lang);
        List<EngineDto> engines = list.get(1).getEngines();
        List<Engine> engineList = engineMapper.entityToDto(engines);
        return engineList;
    }

}
