package com.horo.horo.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TranslateClient {

    // Создание бина RestTemplateTr
    @Bean
    public RestTemplate restTemplateTr() {
        // RestTemplate используется для выполнения HTTP-запросов к внешним сервисам
        return new RestTemplate();
    }
}