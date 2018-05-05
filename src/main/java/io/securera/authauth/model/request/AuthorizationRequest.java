package io.securera.authauth.model.request;

public class AuthorizationRequest {
    private String responseType; // REQUIRED
    private String clientId; // REQUIRED
    private String redictUri; // OPTIONAL
    private String scope; // OPTIONAL
    private String state; // RECOMMENDED
}
