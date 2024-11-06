package ru.horoscope.horoscopeAPI.model.request;

import java.util.List;

public class TranslationApiResponse {
    private List<TranslationApiInfo> translation;

    public TranslationApiResponse(List<TranslationApiInfo> translation) {
        this.translation = translation;
    }

    public TranslationApiResponse() {
    }

    public List<TranslationApiInfo> getTranslation() {
        return translation;
    }

    public void setTranslation(List<TranslationApiInfo> translation) {
        this.translation = translation;
    }
}
