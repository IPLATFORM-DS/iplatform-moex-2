package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.dto.engine.Timetable;

import java.util.List;

@Service
public class EngineParamTimetable implements EngineFactoryInterface {

    @Override
    public List<Timetable> getEngineObjectPart(List<SingleEngineJsonDto> list) {
        return list.get(1).getTimetable();
    }
}
