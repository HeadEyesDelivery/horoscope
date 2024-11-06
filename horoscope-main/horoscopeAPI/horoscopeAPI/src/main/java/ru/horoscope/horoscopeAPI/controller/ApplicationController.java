package ru.horoscope.horoscopeAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.horoscope.horoscopeAPI.service.ApplicationService;



@RestController
@RequestMapping("/horoscope/api/")
public class ApplicationController {
    private final ApplicationService service;

    @Autowired
    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping(value = "test")
    public ResponseEntity<Void> test() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
/*
Как работает код:

Запрос: Когда клиент отправляет запрос GET к
http://[your-host]:[your-port]/horoscope/api/test,
Spring Boot вызывает метод test() в контроллере ApplicationController.
Обработка: Метод test() выполняет некоторые действия
(в данном случае он ничего не делает, кроме возвращения кода статуса OK).
Ответ: Метод test() возвращает ответ с кодом статуса OK (200).
В итоге:

Этот код определяет простой endpoint REST API для тестирования.
 Он не выполняет никаких специфических действий, но позволяет проверить,
 работает ли контроллер и Spring Boot в целом.
 */