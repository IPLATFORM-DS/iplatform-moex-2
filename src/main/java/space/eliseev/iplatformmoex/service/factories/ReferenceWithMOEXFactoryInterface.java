package space.eliseev.iplatformmoex.service.factories;

import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;

import java.net.URISyntaxException;
import java.util.List;

public interface ReferenceWithMOEXFactoryInterface {
    Object getIndexObjectPart(List<ReferenceWithMOEXJsonDto> list) throws URISyntaxException;
}
