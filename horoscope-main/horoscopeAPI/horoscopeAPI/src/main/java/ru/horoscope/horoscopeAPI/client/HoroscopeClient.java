package ru.horoscope.horoscopeAPI.client;


import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.horoscope.horoscopeAPI.model.request.HoroscopeApiResponse;

/*
Создает прокси-клиент для API “https://any.ge” с помощью Spring Cloud OpenFeign.
Определяет метод getHoroscope для отправки запросов GET к API.
Автоматически обрабатывает ответы API и преобразует их в объекты HoroscopeApiResponse.
 */


@FeignClient(value = "horoscopeapi", url = "https://any.ge")
public interface HoroscopeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/horoscope/api/")
    HoroscopeApiResponse getHoroscope(@RequestParam("sign") String sign,
                                  @RequestParam("type") String type,
                                  @RequestParam("day") String day,
                                  @RequestParam("lang") String lang);
}
