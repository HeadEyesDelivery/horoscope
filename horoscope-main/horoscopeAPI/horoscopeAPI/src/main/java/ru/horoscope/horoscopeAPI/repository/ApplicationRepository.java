package ru.horoscope.horoscopeAPI.repository;
import  ru.horoscope.horoscopeAPI.model.document.Horoscope;
import java.util.List;
/*
Этот код определяет интерфейс репозитория
для работы с гороскопами (Horoscope),
хранящимися в базе данных.
Он описывает методы, которые будут использоваться
для взаимодействия с данными, но не предоставляет конкретную реализацию этих методов.
 */
public interface ApplicationRepository {
    void insert(Horoscope horoscope);
    void insert(List<Horoscope> horoscopes);
    Horoscope findById(String id);
    List<Horoscope> findByName(String name);
    void deleteHoroscopeDocuments();
}
/*
void insert(Horoscope horoscope) - вставляет новый гороскоп в базу данных.
void insert(List<Horoscope> horoscopes) - вставляет сразу несколько гороскопов.
Horoscope findById(String id) - возвращает гороскоп по его идентификатору.
List<Horoscope> findByName(String name) - возвращает список гороскопов по имени знака зодиака.
void deleteHoroscopeDocuments() - удаляет все документы о гороскопах из базы данных.
 */