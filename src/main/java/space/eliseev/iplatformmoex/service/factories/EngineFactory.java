package space.eliseev.iplatformmoex.service.factories;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.EngineParam;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
@Slf4j
public class EngineFactory {
    private final EngineParamTimetable timetableP;
    private final EngineParamDailyTable dailyTableP;
    private final EngineParamEngine engineP;

    private final EngineParamNull nullP;
    private final Map<String, Supplier<EngineFactoryInterface>> map = new HashMap<>();


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
                    } catch (URISyntaxException e) {
                        log.error("Error while parsing URI");
                    }
                    return new Object();
                });
    }
}