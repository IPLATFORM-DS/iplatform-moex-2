package space.eliseev.iplatformmoex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class IplatformMoexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IplatformMoexApplication.class, args);
    }

}
