package space.eliseev.iplatformmoex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("space.eliseev.iplatformmoex")
public class Config {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    Environment environment;
}
