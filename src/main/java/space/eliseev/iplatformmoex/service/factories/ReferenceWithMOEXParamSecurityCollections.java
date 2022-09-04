package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.entity.SecurityCollection;

import java.net.URISyntaxException;
import java.util.List;
@Service
public class ReferenceWithMOEXParamSecurityCollections implements ReferenceWithMOEXFactoryInterface {
    @Override
    public List<SecurityCollection> getIndexObjectPart(List<ReferenceWithMOEXJsonDto> list) throws URISyntaxException {
        return list.get(1).getSecuritycollections();
    }
}
