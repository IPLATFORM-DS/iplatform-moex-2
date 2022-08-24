package space.eliseev.iplatformmoex.service;


import org.springframework.lang.Nullable;

public interface SecstatsService {

    Object getSecstats( String engine,  String market,
                        @Nullable Integer tradingsession,
                        @Nullable String securities,
                        @Nullable String boardid);
}
