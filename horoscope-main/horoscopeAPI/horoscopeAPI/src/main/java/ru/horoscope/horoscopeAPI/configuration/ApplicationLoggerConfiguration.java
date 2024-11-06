package ru.horoscope.horoscopeAPI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/*
Этот файл создает конфигурацию для логгера с именем “horoscope_logger”.
 Он предоставляет доступ к этому логгеру для других частей приложения,
 что позволяет записывать информацию о работе приложения в консоль или в файлы.
 */


@Configuration
public class ApplicationLoggerConfiguration {
    @Bean
    public Logger applicationLogger() {
        return Logger.getLogger("horoscope_logger");
    }
}
