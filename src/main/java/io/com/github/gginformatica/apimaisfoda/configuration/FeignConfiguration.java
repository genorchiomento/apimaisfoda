package io.com.github.gginformatica.apimaisfoda.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("io.com.github.gginformatica.apimaisfoda")
public class FeignConfiguration {

}
