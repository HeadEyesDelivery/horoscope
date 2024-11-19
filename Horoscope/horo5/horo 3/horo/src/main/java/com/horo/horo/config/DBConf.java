package com.horo.horo.config;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class DBConf {
    // Создание бина CouchDbClient
    @Bean
    public CouchDbClient couchDbClient() {
        // Настройка свойств для подключения к базе данных CouchDB
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("horoscope") // Имя базы данных
                .setCreateDbIfNotExist(true) // Создать базу данных, если она не существует
                .setProtocol("http") // Протокол подключения
                .setHost("127.0.0.1") // Хост CouchDB
                .setPort(5984) // Порт CouchDB
                .setUsername("admin") // Имя пользователя для аутентификации
                .setPassword("1"); // Пароль для аутентификации

        // Создание и возврат клиента CouchDB с указанными свойствами
        return new CouchDbClient(properties);
    }
}







