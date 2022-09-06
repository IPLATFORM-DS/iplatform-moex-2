package space.eliseev.iplatformmoex.service.factories;

import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;

import java.net.URISyntaxException;
import java.util.List;

public interface EngineFactoryInterface {
    Object getEngineObjectPart(List<SingleEngineJsonDto> list) throws URISyntaxException;
}