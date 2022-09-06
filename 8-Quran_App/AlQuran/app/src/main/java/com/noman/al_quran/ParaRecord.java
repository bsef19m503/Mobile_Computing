package com.noman.al_quran;

public class ParaRecord {
    int ParaID;
    int AyaID;
    String ArabicText;
    String UrduTranslation;
    String EnglishTranslation;

    public ParaRecord(int paraID, int ayaID, String arabicText, String urduTranslation, String englishTranslation) {
        ParaID = paraID;
        AyaID = ayaID;
        ArabicText = arabicText;
        UrduTranslation = urduTranslation;
        EnglishTranslation = englishTranslation;
    }

    public ParaRecord() {
        ParaID = -1;
        AyaID = -1;
        ArabicText = "";
        UrduTranslation = "";
        EnglishTranslation = "";
    }

    public int getParaID() {
        return ParaID;
    }

    public void setParaID(int paraID) {
        ParaID = paraID;
    }

    public int getAyaID() {
        return AyaID;
    }

    public void setAyaID(int ayaID) {
        AyaID = ayaID;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public void setArabicText(String arabicText) {
        ArabicText = arabicText;
    }

    public String getUrduTranslation() {
        return UrduTranslation;
    }

    public void setUrduTranslation(String urduTranslation) {
        UrduTranslation = urduTranslation;
    }

    public String getEnglishTranslation() {
        return EnglishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        EnglishTranslation = englishTranslation;
    }
}
