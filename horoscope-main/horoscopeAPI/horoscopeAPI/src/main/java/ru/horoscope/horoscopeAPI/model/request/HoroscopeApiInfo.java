package ru.horoscope.horoscopeAPI.model.request;

public class HoroscopeApiInfo {

    private final String sign;
    private final String text;
    private final String date;
    private final String type;

    public HoroscopeApiInfo(String sign, String text, String date, String type) {
        this.sign = sign;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getSign() {
        return sign;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Гороскоп{" +
                "Знак='" + sign + '\'' +
                ", Прогноз='" + text + '\'' +
                ", Дата='" + date + '\'' +
                ", Тип='" + type + '\'' +
                '}';
    }
}
