package space.eliseev.iplatformmoex.service.factories;

import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.entity.BoardGroup;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class ReferenceWithMOEXParamBoardgroups implements ReferenceWithMOEXFactoryInterface {
    @Override
    public List<BoardGroup> getIndexObjectPart(List<ReferenceWithMOEXJsonDto> list) throws URISyntaxException {
        return list.get(1).getBoardgroups();
    }
}
