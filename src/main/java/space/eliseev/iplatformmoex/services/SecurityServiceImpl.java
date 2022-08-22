package space.eliseev.iplatformmoex.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService{
    private final SecurityClient securityClient;

    public Object getSecurities(Engine engine, Market market, String q, String lang, String isTrading, String groupBy, String groupByFilter, String limit, Integer start) {
        return securityClient.getSecurities(engine, market, q, lang, isTrading, groupBy, groupByFilter, limit, start);
    }

    @Override
    public Object getSecurityAggregates(String security, String date, String lang) {
        return securityClient.getSecurityAggregates(security, date, lang);
    }
}
