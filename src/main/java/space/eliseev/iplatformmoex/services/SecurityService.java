package space.eliseev.iplatformmoex.services;

import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;

public interface SecurityService {
    Object getSecurities(Engine engine, Market market, String q, String lang, String isTrading, String groupBy, String groupByFilter, String limit, Integer start);
}
