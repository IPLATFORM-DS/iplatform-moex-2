package space.eliseev.iplatformmoex.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;
import space.eliseev.iplatformmoex.configuration.UrlConfig;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final SecurityClient securityClient;
    private final UrlConfig urlConfig;

    @SneakyThrows
    public Object getSecurities(Engine engine, Market market, String q, String lang, String isTrading, String groupBy, String groupByFilter, String limit, Integer start) {
        return securityClient.getSecurities(
                new URI(urlConfig.getSecurities()), engine, market, q, lang, isTrading, groupBy, groupByFilter, limit, start);
    }

    @SneakyThrows
    public Object getSecurityAggregates(String security, String date, String lang) {
        return securityClient.getSecurityAggregates(
                new URI(urlConfig.getAggregates(security)), date, lang);
    }
}
