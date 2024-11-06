package ru.horoscope.horoscopeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@EnableCouchbaseRepositories
@EnableFeignClients
@SpringBootApplication
public class HoroscopeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoroscopeApiApplication.class, args);
	}

}
