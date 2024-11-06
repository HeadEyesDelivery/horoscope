package ru.horoscope.horoscopeAPI.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;


@Document()
public class Horoscope {
    @Id
    private String id; // Идентификатор документа в Couchbase

    @Field("sign")
    private String sign;

    @Field("text")
    private String text;

    @Field("date")
    private String date;

    @Field("type")
    private String type;

    public Horoscope (String sign, String text, String date, String type) {
        this.sign = sign;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Гороскоп{" +"id='" + id + '\'' +
                "Знак='" + sign + '\'' +
                ", Прогноз='" + text + '\'' +
                ", Дата='" + date + '\'' +
                ", Тип='" + type + '\'' +
                '}';
    }
}


/*
@Document: Эта аннотация указывает, что этот класс
представляет собой модель данных для документа в Couchbase.
@Id: Аннотация @Id применяется к полю id, чтобы указать,
что это поле является уникальным идентификатором документа в Couchbase.
@Field: Аннотация @Field применяется к каждому полю,
чтобы указать, что оно соответствует полю в документе Couchbase.
 */

/*
Создание нового объекта Horoscope:
Когда вы создаете новый объект Horoscope
с помощью конструктора, поле id остается null.
Spring Data Couchbase автоматически генерирует
 уникальный id для нового документа при сохранении объекта в Couchbase.
 */
