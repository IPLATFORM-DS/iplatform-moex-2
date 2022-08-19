package space.eliseev.iplatformmoex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatformmoex.model.entity.Engine;
import space.eliseev.iplatformmoex.service.EngineService;


import java.util.*;

@RestController
public class EngineController {


    @Autowired
    private EngineService engineService;

    @GetMapping(value = "/engine", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Engine> getEngine(@RequestParam(value = "lang", required = false)String lang){
     List<Engine> engines=new ArrayList<>();
        List<Object> all=engineService.getEngines(lang);
        for(Object o:all){
            LinkedHashMap ob=(LinkedHashMap)o;
            LinkedHashMap rows = (LinkedHashMap)ob.get("rows");
            List row=(List)rows.get("row");
            for(Object obj:row){
                Integer id= Integer.parseInt ((String)((LinkedHashMap<?, ?>) obj).get("id"));
                String name= (String) ((LinkedHashMap<?, ?>) obj).get("name");
                String title= (String) ((LinkedHashMap<?, ?>) obj).get("title");
                Engine engine=new Engine();
                engine.setId(id);
                engine.setName(name);
                engine.setTitle(title);
                engines.add(engine);
            }
        }
        return engines;
    }
}
