package space.eliseev.iplatformmoex.service.factories;


import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.engine.Dailytable;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;

import java.util.List;

@Service
public class EngineParamDailyTable implements EngineFactoryInterface {

    @Override
    public List<Dailytable> getEngineObjectPart(List<SingleEngineJsonDto> list) {
        return list.get(1).getDailytable();
    }
}
