package test.java.ru.horoscope.horoscopeAPI.module;

public class response {
    private String sign;
    private string text;
    private string date;
    private string type;

    public response (String sign, string text, string date, string type) {
        this.sign = sign;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public string getText() {
        return text;
    }

    public void setText(string text) {
        this.text = text;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public string getDate() {
        return date;
    }

    public void setDate(string date) {
        this.date = date;
    }

    public string getType() {
        return type;
    }

    public void setType(string type) {
        this.type = type;
    }

    public response() {
    }

}
