package com.horo.horo.service;
import com.horo.horo.model.Horoscope;

import java.util.List;
public interface HoroscopeServiceIn {
    void fetchAndSaveHoroscopes(List<String> signs, String type, String day);
    void fetchAndSaveHoroscope(String sign, String type, String day);
    void translateHoroscope(Horoscope horo);
    Horoscope getHoroscope(String sign,String date);
}
