package ru.horoscope.horoscopeAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.horoscope.horoscopeAPI.client.HoroscopeClient;
import ru.horoscope.horoscopeAPI.client.TranslationClient;
import ru.horoscope.horoscopeAPI.model.document.Horoscope;
import ru.horoscope.horoscopeAPI.model.request.HoroscopeApiInfo;
import ru.horoscope.horoscopeAPI.model.request.HoroscopeApiResponse;
import ru.horoscope.horoscopeAPI.model.request.TranslationApiResponse;
import ru.horoscope.horoscopeAPI.model.request.TranslationApiInfo;
import ru.horoscope.horoscopeAPI.repository.ApplicationRepository;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*
Этот код представляет собой сервисный класс, который выполняет
задачу загрузки данных о гороскопах из внешнего API,
перевода их на русский язык и сохранения в базу данных.
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final HoroscopeClient horoscopeClient;
    private final TranslationClient translationClient;
    private final Logger applicationLogger;
    private final ApplicationRepository repository;

    @Autowired
    public ApplicationServiceImpl(HoroscopeClient horoscopeClient, TranslationClient translationClient, ApplicationRepository repository, Logger applicationLogger) {
        this.horoscopeClient = horoscopeClient;
        this.translationClient = translationClient;
        this.repository = repository;
        this.applicationLogger = applicationLogger;
    }

    @PostConstruct
    private void preloadingData() {
        applicationLogger.info("Старт загрузки данных из API.");

        applicationLogger.info("Чистим БД от старых данных.");
        repository.deleteHoroscopeDocuments();

        applicationLogger.info("Запрос данных из API.");
        HoroscopeApiResponse response = horoscopeClient.getHoroscope("cancer", "daily", "today", "en");
        List<HoroscopeApiInfo> horoApi = response.getHoroscope();
        List<Horoscope> horoDocs = new ArrayList<>();

        applicationLogger.info("Полученные данные.");
        for (HoroscopeApiInfo horoscope : horoApi) {
            applicationLogger.info(horoscope.toString());

            // Переводим текст гороскопа на русский язык
            TranslationApiResponse translationResponse = translationClient.translate("en", "ru", horoscope.getText());
            String translatedText = translationResponse.getTranslation().get(0).getDestinationText();

            horoDocs.add(new Horoscope(horoscope.getSign(), translatedText, horoscope.getDate(), horoscope.getType()));
        }

        applicationLogger.info("Загрузка информации в БД...");
        repository.insert(horoDocs);

        applicationLogger.info("Информация загружена.");
    }
}
