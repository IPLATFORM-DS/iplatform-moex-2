package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.ReferenceWithMOEXClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Index;
import space.eliseev.iplatformmoex.service.ReferenceWithMOEXService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceWithMOEXServiceImpl implements ReferenceWithMOEXService {
    private final ReferenceWithMOEXClient client;
    private final UrlConfig urlConfig;

    private static Logger log= LoggerFactory.getLogger(ReferenceWithMOEXServiceImpl.class);

    @Override
    public Object getReferenceWithMOEX(Index param, String lang, Engine engine,
                                             Integer isTraded, Integer hideInactive,
                                             String securitygroups, String tradeEngine) {
        try {
            if(param==null){
                return  client.getReferenceWithMOEX(new URI(urlConfig.getIndex(null)),
                        lang, engine,isTraded, hideInactive, securitygroups, tradeEngine);
            }
            return  client.getReferenceWithMOEX(new URI(urlConfig.getIndex(param.getName())),
                    lang, engine,isTraded, hideInactive, securitygroups, tradeEngine);
        } catch (URISyntaxException e) {
            log.error("Error parsing URL");
        }
        return null;
    }
}
