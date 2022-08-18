package space.eliseev.iplatformmoex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import space.eliseev.iplatformmoex.configuration.UrlConfig;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(UrlConfig.class)
public class IplatformMoexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IplatformMoexApplication.class, args);
    }

}
