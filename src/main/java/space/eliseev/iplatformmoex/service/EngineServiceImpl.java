package space.eliseev.iplatformmoex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import space.eliseev.iplatformmoex.model.entity.Engine;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EngineServiceImpl {
    @Autowired
    EngineService engineService;

    public List<Engine> engineList(@RequestParam(value = "lang", required = false)String lang){
        LinkedHashMap all= (LinkedHashMap) engineService.getEngines(lang);
        LinkedHashMap data= (LinkedHashMap) all.get("data");
        LinkedHashMap rows= (LinkedHashMap) data.get("rows");
        List<Object> row= (List<Object>) rows.get("row");
        List<Engine> engines = row.stream().map(o->{
            Integer id= Integer.parseInt ((String)((LinkedHashMap<?, ?>) o).get("id"));
            String name= (String) ((LinkedHashMap<?, ?>) o).get("name");
            String title= (String) ((LinkedHashMap<?, ?>) o).get("title");
            Engine engine=new Engine();
            engine.setId(id);
            engine.setName(name);
            engine.setTitle(title);
            return engine;
        }).collect(Collectors.toList());
        return engines;
    }
}
