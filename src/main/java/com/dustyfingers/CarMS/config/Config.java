package com.dustyfingers.CarMS.config;

import com.dustyfingers.CarMS.exceptions.RestErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.dustyfingers.CarMS")
@PropertySource("classpath:application.properties")
public class Config {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().errorHandler(new RestErrorHandler()).build();
    }
}
