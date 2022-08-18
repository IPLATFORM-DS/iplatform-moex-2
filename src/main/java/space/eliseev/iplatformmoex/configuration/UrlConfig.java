package space.eliseev.iplatformmoex.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties("url")
@PropertySource(value = "classpath:url-config.yml", factory = YamlPropertySourceFactory.class)
public class UrlConfig {
    private String securities;
    private String security;
    private String indices;
    private String aggregates;
    private String secstats;

    public String getAggregates(String security) {
        return aggregates.replace("[security]", security);
    }

}

class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public org.springframework.core.env.PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(encodedResource.getResource());
        return new PropertiesPropertySource(encodedResource.getResource().getFilename(), factory.getObject());
    }
}
