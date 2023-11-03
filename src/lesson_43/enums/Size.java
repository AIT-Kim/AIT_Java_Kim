package lesson_43.enums;

public enum Size {
    S("46-48", "36-38"),
    M("48-50", "38-40"),
    L("50-52", "40-42");

    private final String europe;
    private final String usa;

    Size(String europe, String usa) {
        this.europe = europe;
        this.usa = usa;
    }

    public String getEurope() {
        return europe;
    }

    public String getUsa() {
        return usa;
    }
}