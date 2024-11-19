package com.horo.horo.model;

public class Horoscope {


    private String sign;
    private String text;
    private String date;
    private String type;

    public Horoscope (String sign, String text, String date, String type) {
        this.sign = sign;
        this.text = text;
        this.date = date;
        this.type = type;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Horoscope() {
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
