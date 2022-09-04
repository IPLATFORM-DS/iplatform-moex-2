package space.eliseev.iplatformmoex.service.factories;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Index;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ReferenceWithMOEXFactory {

    private final ReferenceWithMOEXParamBoardgroups boardGroups;
    private final ReferenceWithMOEXParamBoards boards;
    private final ReferenceWithMOEXParamDurations durations;
    private final ReferenceWithMOEXParamEngines engines;
    private final ReferenceWithMOEXParamMarkets markets;
    private final ReferenceWithMOEXParamSecurityCollections securityCollections;
    private final ReferenceWithMOEXParamSecurityGroups securityGroups;
    private final ReferenceWithMOEXParamSecurityTypes securityTypes;

    private final ReferenceWithMOEXParamNull nullParam;

    private Map<String, Supplier<ReferenceWithMOEXFactoryInterface>> map = new HashMap<>();
    private Logger log = LoggerFactory.getLogger(ReferenceWithMOEXFactory.class);

    @PostConstruct
    public void init() {
        map.put(Index.BOARDGROUPS.getName(), () -> boardGroups);
        map.put(Index.BOARDS.getName(), () -> boards);
        map.put(Index.DURATIONS.getName(), () -> durations);
        map.put(Index.ENGINES.getName(), () -> engines);
        map.put(Index.MARKETS.getName(), () -> markets);
        map.put(Index.SECURITYCOLLECTIONS.getName(), () -> securityCollections);
        map.put(Index.SECURITYGROUPS.getName(), () -> securityGroups);
        map.put(Index.SECURITYTYPES.getName(), () -> securityTypes);
        map.put(null, () -> nullParam);
    }

    public Object showIndexData(String paramType, List<ReferenceWithMOEXJsonDto> list) {
        return Optional.ofNullable(map.get(paramType))
                .map(formBuilder -> {
                    try {
                        return formBuilder.get().getIndexObjectPart(list);
                    } catch (URISyntaxException e) {
                        log.error("Error while parsing URI");
                    }
                    return null;
                });
    }

}
