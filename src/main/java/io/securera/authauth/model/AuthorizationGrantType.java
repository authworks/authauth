package io.securera.authauth.model;

public enum AuthorizationGrantType {
    AuthorizationCode("authorization_code"),
    Implicit("implicit");

    private String value;

    AuthorizationGrantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AuthorizationGrantType fromValue(String value) {
        for (AuthorizationGrantType type : AuthorizationGrantType.values()){
            if (type.getValue().equals(value)){
                return type;
            }
        }
        throw new UnsupportedOperationException("The value " + value + " is not supported!");
    }
}
