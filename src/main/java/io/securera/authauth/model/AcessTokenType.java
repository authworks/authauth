package io.securera.authauth.model;

public enum  AcessTokenType {
    Bearer("bearer"),
    MAC("mac");

    private String value;
    AcessTokenType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
