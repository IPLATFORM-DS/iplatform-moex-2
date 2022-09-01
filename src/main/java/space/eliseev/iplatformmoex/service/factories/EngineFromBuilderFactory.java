package space.eliseev.iplatformmoex.service.factories;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.EngineParam;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class EngineFromBuilderFactory {
    private final  EngineFromBuilderParamTimetable timetableP;
    private final  EngineFromBuilderParamDailyTable dailyTableP;
    private final  EngineFromBuilderParamEngine engineP;

    private final EngineFromBuilderParamNull nullP;
    private final Map<String, Supplier<EngineFromBuilder>> map = new HashMap<>();
    Logger log = LoggerFactory.getLogger(EngineFromBuilderFactory.class);

    @PostConstruct
    public void init() {
        map.put(EngineParam.ENGINE.getName(), () -> engineP);
        map.put(EngineParam.TIMETABLE.getName(), () -> timetableP);
        map.put(EngineParam.DAILYTABLE.getName(), () -> dailyTableP);
        map.put(null,()->nullP);

    }

    public Object showEngineData(String paramType, List<SingleEngineJsonDto> list){
        return Optional.ofNullable(map.get(paramType))
                .map(formBuilder -> {
                    try {
                        return formBuilder.get().getEngineObjectPart(list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .orElseThrow(() -> {
                    log.error("Param type not found");
                    return new IllegalArgumentException("Error during defining param. Param type not found");
                });
    }
}
