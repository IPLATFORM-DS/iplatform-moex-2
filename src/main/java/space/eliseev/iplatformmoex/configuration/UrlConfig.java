package space.eliseev.iplatformmoex.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:url-config.yml")
public class UrlConfig {

    @Value("${securities}")
    private String securities;

    @Value("${security}")
    private String security;

    @Value("${indices}")
    private String indices;

    @Value("${aggregates}")
    private String aggregates;

    @Value("${secstats}")
    private String secstats;

    public String getSecurity(String security) {
        return security.replace("[security]", security);
    }
    public String getAggregates(String security) {
        return aggregates.replace("[security]", security);
    }
    public String getIndices(String security) {
        return indices.replace("[security]", security);
    }

    public String getSecstats(String engine, String market) {
        return secstats.replace("[engine]", engine).replace("[market]", market);
    }

}
