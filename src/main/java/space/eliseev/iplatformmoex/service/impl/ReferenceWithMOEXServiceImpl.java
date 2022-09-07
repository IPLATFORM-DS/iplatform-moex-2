package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.ReferenceWithMOEXClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.model.dto.ReferenceWithMOEX.ReferenceWithMOEXJsonDto;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Index;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReferenceWithMOEXServiceImpl implements ReferenceWithMOEXService {
    private final ReferenceWithMOEXClient client;
    private final UrlConfig urlConfig;


    @Override
    public List<ReferenceWithMOEXJsonDto> getReferenceWithMOEX(Index param, String lang, Engine engine,
                                                               Integer isTraded, Integer hideInactive,
                                                               String tradeEngine) {
        try {
            if(param==null){
                return  client.getReferenceWithMOEX(new URI(urlConfig.getIndex(null)),
                        lang, engine,isTraded, hideInactive, tradeEngine);
            }
            return  client.getReferenceWithMOEX(new URI(urlConfig.getIndex(param.getName())),
                    lang, engine,isTraded, hideInactive, tradeEngine);
        } catch (URISyntaxException e) {
            log.error("Error parsing URL");
        }
        return new ArrayList<>();
    }
}
