package io.com.github.gginformatica.apimaisfoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApimaisfodaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApimaisfodaApplication.class, args);
    }
}
