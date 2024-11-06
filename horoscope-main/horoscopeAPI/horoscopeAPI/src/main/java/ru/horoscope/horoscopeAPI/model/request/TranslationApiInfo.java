package ru.horoscope.horoscopeAPI.model.request;

public class TranslationApiInfo {

    private String sourceLanguage;
    private String sourceText;
    private String destinationLanguage;
    private String destinationText;
    private String pronunciation;
    private String translations;
    private String definitions;
    private String see_also;

    public TranslationApiInfo(String sourceLanguage, String sourceText, String destinationLanguage, String destinationText, String pronunciation, String translations, String definitions, String see_also) {
        this.sourceLanguage = sourceLanguage;
        this.sourceText = sourceText;
        this.destinationLanguage = destinationLanguage;
        this.destinationText = destinationText;
        this.pronunciation = pronunciation;
        this.translations = translations;
        this.definitions = definitions;
        this.see_also = see_also;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getSourceText() {
        return sourceText;
    }

    public String getDestinationLanguage() {
        return destinationLanguage;
    }

    public String getDestinationText() {
        return destinationText;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getTranslations() {
        return translations;
    }

    public String getDefinitions() {
        return definitions;
    }

    public String getSee_also() {
        return see_also;
    }

    @Override
    public String toString() {
        return "TranslationInfo{" +
                "sourceLanguage='" + sourceLanguage + '\'' +
                ", sourceText='" + sourceText + '\'' +
                ", destinationLanguage='" + destinationLanguage + '\'' +
                ", destinationText='" + destinationText + '\'' +
                '}';
    }
}