package space.eliseev.iplatformmoex.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatformmoex.client.SecuritiesClient;

@Service
@RequiredArgsConstructor
public class SecuritiesService {
    private final SecuritiesClient securitiesClient;

    public Object getSecurities(String q, String lang, String engine, String is_trading, String market, String group_by, String group_by_filter, Integer limit, Integer start) {
        return securitiesClient.getSecurities(q, lang, engine, is_trading, market, group_by, group_by_filter, limit, start);
    }
}
