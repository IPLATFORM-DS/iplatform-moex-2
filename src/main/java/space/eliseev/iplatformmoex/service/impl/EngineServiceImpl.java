package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.entity.Engine;
import space.eliseev.iplatformmoex.service.EngineService;
import space.eliseev.iplatformmoex.service.client.EngineClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineClient engineClient;

    @Override
    public Object getEngines(@Nullable String lang) {
        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ArrayList<LinkedHashMap<String, String>>>>>
                data = (LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String,
                ArrayList<LinkedHashMap<String, String>>>>>) engineClient.getEngines(lang);
        List<Engine> engins = data.get("data").get("rows").get("row").stream().map(o -> {
            Integer id = Integer.parseInt(o.get("id"));
            String name = o.get("name");
            String title = o.get("title");
            Engine engine = new Engine();
            engine.setId(id);
            engine.setName(name);
            engine.setTitle(title);
            return engine;

        }).collect(Collectors.toList());
        return engins;
    }
}
