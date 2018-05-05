package io.securera.authauth.service;

import io.securera.authauth.model.Client;

public class ClientRegistrationService {

    public Client findClientRegistration(String clientId) {
        return null;
    }

    public boolean supportAuthenticationMethod(String method) {
        return true;
    }

    public boolean supportRedirectUris(String redirectUri) {
        return true;
    }

    public boolean supportAuthorizationGrantType(String authorizationGrantType) {
        return true;
    }
}
