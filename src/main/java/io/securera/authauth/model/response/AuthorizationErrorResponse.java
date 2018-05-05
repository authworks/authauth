package io.securera.authauth.model.response;

public class AuthorizationErrorResponse implements AuthorizationResponse {
    private static final String INVALID_REQUEST = "invalid_request";
    private static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
    private static final String ACCESS_DENIED = "access_denied";
    private static final String UNSUPPORTED_RESPONSE_TYPE = "unsupported_response_type";
    private static final String INVALID_SCOPE = "invalid_scope";
    private static final String SERVER_ERROR = "server_error";
    private static final String TEMPORARILY_UNAVAILABLE = "temporarily_unavailable";

    public static final AuthorizationErrorResponse UNSUPPORTED_RESPONSE_TYPE_ERROR = new AuthorizationErrorResponse(UNSUPPORTED_RESPONSE_TYPE);

    public AuthorizationErrorResponse(String error, String errorDescription, String errorUri, String state) {
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorUri = errorUri;
        this.state = state;
    }

    public AuthorizationErrorResponse(String error) {
        this.error = error;
    }

    private String error; // REQUIRED

    private String errorDescription; // OPTIONAL

    private String errorUri; // OPTIONAL

    private String state; // DEPENDS ON REQUEST

    @Override
    public String urlEncoded() {
        return String.format("error=%s&error_description=%s&error_uri=%s&state=%s", error, errorDescription, errorUri, state);
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}