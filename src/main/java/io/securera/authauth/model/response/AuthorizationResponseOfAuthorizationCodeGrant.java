package io.securera.authauth.model.response;

public class AuthorizationResponseOfAuthorizationCodeGrant implements AuthorizationResponse {
    private String code; // REQUITED
    private String state; // REQUIRED if the "state" parameter was present in the client authorization request

    @Override
    public String urlEncoded() {
        return String.format("code=%s&state=%s", code, state);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
