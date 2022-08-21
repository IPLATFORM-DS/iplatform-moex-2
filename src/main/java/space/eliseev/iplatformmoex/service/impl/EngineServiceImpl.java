package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.service.EngineService;
import space.eliseev.iplatformmoex.service.client.EngineClient;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineClient engineClient;

    @Override
    public Object getEngines(@Nullable String lang) {
        return engineClient.getEngines(lang);
    }

//    public List<Engine> engineList(@RequestParam(value = "lang", required = false) String lang) {
//        LinkedHashMap all = (LinkedHashMap) engineClient.getEngines(lang);
//        LinkedHashMap data = (LinkedHashMap) all.get("data");
//        LinkedHashMap rows = (LinkedHashMap) data.get("rows");
//        List<Object> row = (List<Object>) rows.get("row");
//        List<Engine> engines = row.stream().map(o -> {
//            Integer id = Integer.parseInt((String) ((LinkedHashMap<?, ?>) o).get("id"));
//            String name = (String) ((LinkedHashMap<?, ?>) o).get("name");
//            String title = (String) ((LinkedHashMap<?, ?>) o).get("title");
//            Engine engine = new Engine();
//            engine.setId(id);
//            engine.setName(name);
//            engine.setTitle(title);
//            return engine;
//        }).collect(Collectors.toList());
//        return engines;
//    }
}
