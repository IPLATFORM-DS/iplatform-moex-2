package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;

import java.util.List;

@Service
public class EngineParamNull implements EngineFactoryInterface {

    @Override
    public SingleEngineJsonDto getEngineObjectPart(List<SingleEngineJsonDto> list) {
        return list.get(1);
    }
}
