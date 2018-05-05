package io.securera.authauth.model.response;

public class AuthorizationResponseOfImplicitGrant implements AuthorizationResponse {

    private String accessToken; // REQUIRED
    private String tokenType; // REQUIRED
    private int expiresIn; // RECOMMENDED
    private String scope; // OPTIONAL
    private String state; // REQUIRED if the "state" parameter was present in the client authorization request

    @Override
    public String urlEncoded() {
        return String.format("access_token=%s&token_type=%s&expires_in=%d&scope=%s&state=%s",
                accessToken, tokenType, expiresIn, scope, state);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
