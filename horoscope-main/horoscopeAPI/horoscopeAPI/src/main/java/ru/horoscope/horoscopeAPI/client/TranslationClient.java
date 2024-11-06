package ru.horoscope.horoscopeAPI.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.horoscope.horoscopeAPI.model.request.TranslationApiResponse;



@FeignClient(value = "translationapi", url = "https://ftapi.pythonanywhere.com")
public interface TranslationClient {
        @RequestMapping(method = RequestMethod.GET, value = "/translate")
        TranslationApiResponse translate(@RequestParam("sl") String sourceLang,
                                      @RequestParam("dl") String destLang,
                                      @RequestParam("text") String text);
    }



