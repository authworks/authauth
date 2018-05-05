package io.securera.authauth.service;

import io.securera.authauth.endpoint.Constants;
import io.securera.authauth.model.AccessToken;
import io.securera.authauth.model.response.AuthorizationErrorResponse;
import io.securera.authauth.model.response.AuthorizationResponse;
import io.securera.authauth.model.response.AuthorizationResponseOfAuthorizationCodeGrant;
import io.securera.authauth.model.response.AuthorizationResponseOfImplicitGrant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private TokenService tokenService;

    public AuthorizationResponse grant(
            String responseType, // REQUIRED
            String clientId, // REQUIRED
            String resourceOwnerId,
            String scope, // OPTIONAL
            String state // RECOMMENDED
    ) {
        if (Constants.ResponseType.CODE.equals(responseType)) {
            return forAuthorizationCode(clientId, state);
        } else if (Constants.ResponseType.TOKEN.equals(responseType)) {
            return forImplicit(clientId, resourceOwnerId, scope, state);
        }

        return AuthorizationErrorResponse.UNSUPPORTED_RESPONSE_TYPE_ERROR;
    }

    private AuthorizationResponseOfAuthorizationCodeGrant forAuthorizationCode(String clientId, String state) {
        AuthorizationResponseOfAuthorizationCodeGrant response = new AuthorizationResponseOfAuthorizationCodeGrant();
        response.setCode(tokenService.issueAuthorizationCode());
        response.setState(state);
        return response;
    }

    private AuthorizationResponseOfImplicitGrant forImplicit(String clientId, String resourceOwnerId, String scope, String state) {
        AuthorizationResponseOfImplicitGrant response = new AuthorizationResponseOfImplicitGrant();
        AccessToken accessToken = tokenService.issueAccessToken(clientId, resourceOwnerId, scope);
        response.setAccessToken(accessToken.getAccessToken());
        response.setTokenType(accessToken.getTokenType());
        response.setExpiresIn(accessToken.getExpiresIn());
        response.setScope(accessToken.getScope());
        response.setState(state);
        return response;
    }
}
