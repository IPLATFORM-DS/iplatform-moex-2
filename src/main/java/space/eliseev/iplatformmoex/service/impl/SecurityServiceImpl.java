package space.eliseev.iplatformmoex.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import space.eliseev.iplatformmoex.service.SecurityService;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityClient securityClient;
    private final UrlConfig urlConfig;

    @SneakyThrows
    @Override
    public Object getSecurities(Engine e, Market m, String q, String lang, String isTrading, String groupBy, String groupByFilter, String limit, Integer start) {
        String engine = (e == null) ? null : e.getName();
        String market = (m == null) ? null : m.getName();
        return securityClient.getSecurities(
                new URI(urlConfig.getSecurities()), engine, market, q, lang, isTrading, groupBy, groupByFilter, limit, start);
    }

    @SneakyThrows
    @Override
    public Object getSecurityAggregates(String security, String date, String lang) {
        return securityClient.getSecurityAggregates(
                new URI(urlConfig.getAggregates(security)), date, lang);
    }

}
