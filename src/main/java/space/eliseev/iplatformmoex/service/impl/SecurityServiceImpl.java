package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.service.SecurityService;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityClient securityClient;

    public Object getSecurities(Engine engine, Market market, String q, String lang, String isTrading, String groupBy, String groupByFilter, String limit, Integer start) {
        return securityClient.getSecurities(engine.getName(), market.getName(), q, lang, isTrading, groupBy, groupByFilter, limit, start);
    }
}
