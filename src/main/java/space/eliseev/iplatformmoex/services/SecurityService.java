package space.eliseev.iplatformmoex.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecurityClient;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final SecurityClient securityClient;

    public Object getSecurities(String q, String lang, String engine, String is_trading, String market, String group_by, String group_by_filter, String limit, Integer start) {
        return securityClient.getSecurities(q, lang, engine, is_trading, market, group_by, group_by_filter, limit, start);
    }

    public Object getSecurityAggregates(String lang, String date) {
        return securityClient.getSecurityAggregates(lang, date);
    }
}
