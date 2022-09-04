package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;

import java.net.URISyntaxException;
import java.util.List;
@Service
public class ReferenceWithMOEXParamNull implements ReferenceWithMOEXFactoryInterface {
    @Override
    public ReferenceWithMOEXJsonDto getIndexObjectPart(List<ReferenceWithMOEXJsonDto> list) throws URISyntaxException {
        return list.get(1);
    }
}
