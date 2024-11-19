package com.horo.horo.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HoroClient {

    // Создание бина RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        // RestTemplate используется для выполнения HTTP-запросов к внешним сервисам
        return new RestTemplate();
    }
}
