package com.dustyfingers.CarMS.config;

import com.dustyfingers.CarMS.service.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.dustyfingers.CarMS")
@PropertySource("classpath:application.properties")
public class Config {

    @Bean(name="carService")
    public CarServiceImpl carService(){
        return new CarServiceImpl();
    }
}
