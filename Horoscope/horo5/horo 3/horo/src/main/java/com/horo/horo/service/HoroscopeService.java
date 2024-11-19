package com.horo.horo.service;

import com.horo.horo.model.Horoscope;
import org.lightcouch.CouchDbClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.horo.horo.service.HoroscopeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import java.io.IOException;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import com.horo.horo.config.DBConf;
import com.horo.horo.client.HoroClient;

@Service
public class HoroscopeService implements HoroscopeServiceIn {

    private final RestTemplate restTemplate;
    private final CouchDbClient dbClient;


    private static final String COUCHDB_URL = "http://localhost:5984";
    private static final String DATABASE_NAME = "horoscope";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1";


    @Override
    public Horoscope getHoroscope(String sign, String date) {
        // Формируем запрос в формате JSON
        String query = String.format(
                "{ \"selector\": { \"sign\": \"%s\", \"date\": \"%s\" }, \"limit\": 1 }",
                sign, date
        );

        // Кодируем авторизацию
        String authHeader = "Basic " + Base64.getEncoder()
                .encodeToString((USERNAME + ":" + PASSWORD).getBytes(StandardCharsets.UTF_8));

        try {
            // Создаем HTTP-клиент
            HttpClient client = HttpClient.newHttpClient();

            // Создаем HTTP-запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(COUCHDB_URL + "/" + DATABASE_NAME + "/_find"))
                    .header("Authorization", authHeader)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(query))
                    .build();

            // Отправляем запрос и получаем ответ
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Проверяем код ответа
            if (response.statusCode() != 200) {
                throw new RuntimeException("Ошибка запроса к CouchDB: " + response.statusCode());
            }

            // Обрабатываем JSON-ответ
            return parseHoroscope(response.body());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении запроса к CouchDB", e);
        }
    }

    private Horoscope parseHoroscope(String jsonResponse) {
        // Пример обработки JSON (можно использовать библиотеку Gson или Jackson)
        com.google.gson.JsonObject json = com.google.gson.JsonParser.parseString(jsonResponse).getAsJsonObject();
        if (json.getAsJsonArray("docs").size() == 0) {
            throw new RuntimeException("Гороскоп не найден");
        }
        com.google.gson.JsonObject doc = json.getAsJsonArray("docs").get(0).getAsJsonObject();
        return new Horoscope(
                doc.get("sign").getAsString(),
                doc.get("date").getAsString(),
                doc.get("prediction").getAsString(),
                "daily"
        );
    }



    @Autowired
    public HoroscopeService(RestTemplate restTemplate, CouchDbClient dbClient) {
        this.restTemplate = restTemplate;
        this.dbClient = dbClient;
    }




    @Override
    public void fetchAndSaveHoroscopes(List<String> signs, String type, String day) {
        for (String sign : signs) {
            fetchAndSaveHoroscope(sign, type, day);
        }
    }

    @Override
    public void fetchAndSaveHoroscope(String sign, String type, String day) {
        String url = String.format("https://any.ge/horoscope/api/?sign=%s&type=%s&day=%s&lang=en", sign, type, day);
        ResponseEntity<Horoscope[]> response = restTemplate.getForEntity(url, Horoscope[].class);
        Horoscope[] horoscopes = response.getBody();

        if (horoscopes != null && horoscopes.length > 0) {
            for (Horoscope horoscope : horoscopes) {
                translateHoroscope(horoscope);
                dbClient.save(horoscope);
                System.out.println("Данные гороскопа сохранены: " + horoscope);
            }
        } else {
            System.out.println("Не удалось получить данные гороскопа для знака: " + sign);
        }
    }

    @Override
    public void translateHoroscope(Horoscope horo) {
        String url = String.format("https://ftapi.pythonanywhere.com/translate?sl=en&dl=ru&text=%s", horo.getText());
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, String> responseBody = response.getBody();
        if (responseBody != null) {
            String translatedText = responseBody.get("destination-text");
            horo.setText(translatedText);
        }
    }
}