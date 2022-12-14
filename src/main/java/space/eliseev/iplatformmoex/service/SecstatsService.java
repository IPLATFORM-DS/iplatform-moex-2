package space.eliseev.iplatformmoex.service;


import org.springframework.lang.Nullable;
import space.eliseev.iplatformmoex.model.enumeration.Engine;
import space.eliseev.iplatformmoex.model.enumeration.Market;

public interface SecstatsService {

    Object getSecstats(Engine engine, Market market,
                       @Nullable Integer tradingsession,
                       @Nullable String securities,
                       @Nullable String boardid);
}
