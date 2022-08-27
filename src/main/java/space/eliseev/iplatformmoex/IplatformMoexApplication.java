package space.eliseev.iplatformmoex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IplatformMoexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IplatformMoexApplication.class, args);
    }

}
