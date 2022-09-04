package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.entity.Duration;

import java.net.URISyntaxException;
import java.util.List;
@Service
public class ReferenceWithMOEXParamDurations implements ReferenceWithMOEXFactoryInterface {
    @Override
    public List<Duration> getIndexObjectPart(List<ReferenceWithMOEXJsonDto> list) throws URISyntaxException {
        return list.get(1).getDurations();
    }
}
