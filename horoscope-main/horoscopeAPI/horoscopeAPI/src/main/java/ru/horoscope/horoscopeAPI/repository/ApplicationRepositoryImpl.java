package ru.horoscope.horoscopeAPI.repository;


import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.query.QueryCriteria;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.horoscope.horoscopeAPI.model.document.Horoscope;

import java.util.List;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final CouchbaseTemplate couchbaseTemplate;

    // Конструктор для внедрения зависимости CouchbaseTemplate
    @Autowired
    public ApplicationRepositoryImpl(CouchbaseTemplate couchbaseTemplate) {
        this.couchbaseTemplate = couchbaseTemplate;
    }

    // Метод для вставки одного документа Horoscope в базу данных
    @Override
    public void insert(Horoscope horoscope) {
        couchbaseTemplate.insertById(Horoscope.class).one(horoscope);
    }

    // Метод для вставки списка документов Horoscope в базу данных
    @Override
    public void insert(List<Horoscope> horoscopes) {
        couchbaseTemplate.insertById(Horoscope.class).all(horoscopes);
    }

    // Метод для поиска документа Horoscope по его идентификатору
    @Override
    public Horoscope findById(String id) {
        return couchbaseTemplate.findById(Horoscope.class).one(id);
    }

    // Метод для поиска документов Horoscope по имени знака зодиака
    @Override
    public List<Horoscope> findByName(String name) {
        Query query = new Query();
        query.addCriteria(QueryCriteria.where("sign").is(name));
        return couchbaseTemplate.findByQuery(Horoscope.class).matching(query).all();
    }

    // Метод для удаления всех документов Horoscope из базы данных
    @Override
    public void deleteHoroscopeDocuments() {
        Query query = new Query();
        query.addCriteria(QueryCriteria.where("_class").is(Horoscope.class.getName()));
        couchbaseTemplate.removeByQuery(Horoscope.class).matching(query).all();
    }
}
