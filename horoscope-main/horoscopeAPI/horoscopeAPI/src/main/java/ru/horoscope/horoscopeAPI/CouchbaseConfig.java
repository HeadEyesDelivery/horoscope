package ru.horoscope.horoscopeAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.data.couchbase.core.convert.CouchbaseConverter;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.core.CouchbaseClientFactory;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    private static final String CONNECTION_STRING = "127.0.0.1:5984"; // Укажите адрес вашего Couchbase сервера
    private static final String USERNAME = "admin"; // Укажите ваше имя пользователя
    private static final String PASSWORD = "1"; // Укажите ваш пароль
    private static final String BUCKET_NAME = "horoscope"; // Укажите название вашего бакета

    @Override
    public String getConnectionString() {
        return CONNECTION_STRING;
    }

    @Override
    public String getUserName() {
        return USERNAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME;
    }

    @Bean
    public CouchbaseTemplate couchbaseTemplate(CouchbaseClientFactory couchbaseClientFactory, CouchbaseConverter couchbaseConverter) {
        return new CouchbaseTemplate(couchbaseClientFactory, couchbaseConverter);
    }

    @Bean
    public ValidatingCouchbaseEventListener validatingCouchbaseEventListener(LocalValidatorFactoryBean factory) {
        return new ValidatingCouchbaseEventListener(factory);
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
