package ru.horoscope.horoscopeAPI.model.request;
import java.util.List;

public class HoroscopeApiResponse {

    private List<HoroscopeApiInfo> horoscope;

    public HoroscopeApiResponse(List<HoroscopeApiInfo> horoscope) {
        this.horoscope = horoscope;
    }

    public HoroscopeApiResponse() {
    }

    public List<HoroscopeApiInfo> getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(List<HoroscopeApiInfo> horoscope) {
        this.horoscope = horoscope;
    }

}
/*
HoroscopeApiInfo - модель для описания одного гороскопа.
HoroscopeApiResponse - модель для описания списка гороскопов, полученного от API.
 */