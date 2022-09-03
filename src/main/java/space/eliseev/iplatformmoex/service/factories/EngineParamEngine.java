package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineDTO;
import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;

import java.util.List;


@Service
public class EngineParamEngine implements EngineFactoryInterface {

    @Override
    public List<SingleEngineDTO> getEngineObjectPart(List<SingleEngineJsonDto> list){
        return list.get(1).getEngine();
    }
}
