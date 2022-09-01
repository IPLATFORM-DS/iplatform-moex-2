package space.eliseev.iplatformmoex.service.factories;

import space.eliseev.iplatformmoex.model.dto.engine.SingleEngineJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Engine;

import java.net.URISyntaxException;
import java.util.List;

public interface EngineFromBuilder {
    Object getEngineObjectPart(List<SingleEngineJsonDto> list) throws URISyntaxException;
}
