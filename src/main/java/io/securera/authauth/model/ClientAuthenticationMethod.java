package io.securera.authauth.model;

public enum ClientAuthenticationMethod {
    HttpBasic("http_basic"),
    RequestBody("request_body");

    private String value;

    ClientAuthenticationMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClientAuthenticationMethod fromValue(String value) {
        for (ClientAuthenticationMethod method : ClientAuthenticationMethod.values()){
            if (method.getValue().equals(value)){
                return method;
            }
        }
        throw new UnsupportedOperationException("The value " + value + " is not supported!");
    }
}
