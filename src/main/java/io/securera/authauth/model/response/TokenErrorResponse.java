package io.securera.authauth.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenErrorResponse {
    private static final String INVALID_REQUEST = "invalid_request";
    private static final String INVALID_CLIENT = "invalid_client";
    private static final String INVALID_GRANT = "invalid_grant";
    private static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
    private static final String UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type";
    private static final String INVALID_SCOPE = "invalid_scope";

    public static TokenErrorResponse UNSUPPORTED_GRANT_TYPE_ERROR = new TokenErrorResponse(UNSUPPORTED_GRANT_TYPE);

    public TokenErrorResponse(String error, String errorDescription, String errorUri) {
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorUri = errorUri;
    }

    public TokenErrorResponse(String error) {
        this.error = error;
    }

    private String error; // REQUIRED

    @JsonProperty("error_description")
    private String errorDescription; // OPTIONAL

    @JsonProperty("error_uri")
    private String errorUri; // OPTIONAL

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorUri() {
        return errorUri;
    }

    public void setErrorUri(String errorUri) {
        this.errorUri = errorUri;
    }
}
