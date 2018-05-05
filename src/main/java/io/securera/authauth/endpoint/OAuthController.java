package io.securera.authauth.endpoint;

import io.securera.authauth.exception.ForbiddenException;
import io.securera.authauth.model.response.AuthorizationResponse;
import io.securera.authauth.model.response.TokenResponse;
import io.securera.authauth.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static io.securera.authauth.endpoint.Constants.*;

@Controller
public class OAuthController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(
            path = "/authorize",
            method = {
                    RequestMethod.GET, // MUST support
                    RequestMethod.POST // May support
            }
    )
    public ModelAndView authorize(@RequestParam(name = RESPONSE_TYPE_PARAM, required = false) String responseType, // REQUIRED
                                  @RequestParam(name = CLIENT_ID_PARAM, required = false) String clientId, // REQUIRED
                                  @RequestParam(name = REDIRECT_URI_PARAM, required = false) String redirectUri, // OPTIONAL
                                  @RequestParam(name = SCOPE_PARAM, required = false) String scope, // OPTIONAL
                                  @RequestParam(name = STATE_PARAM, required = false) String state, // RECOMMENDED
                                  HttpMethod httpMethod,
                                  HttpServletRequest httpServletRequest,
                                  HttpSession httpSession,
                                  ModelMap modelMap) {

        if (httpMethod == HttpMethod.GET) {
            modelMap.put("query", httpServletRequest.getQueryString());
            return new ModelAndView(AUTHENTICATION_VIEW);
        }

        if (httpMethod == HttpMethod.POST) {
            if(httpSession == null || httpSession.isNew() || (Boolean) httpSession.getAttribute("logined") != true) {
                throw new ForbiddenException("Not logined to approve consent");
            }
            String resourceOwnerId = (String) httpSession.getAttribute("userId");
            return new ModelAndView(
                    redirect(redirectUri, authorizationService.grant(responseType, clientId, resourceOwnerId, scope, state))
            );
        }

        throw new ForbiddenException("Unsupported Http method");
    }

    private String redirect(String redirectUri, AuthorizationResponse response) {
        return String.format("redirect:%s?%s", redirectUri, response.urlEncoded());
    }

    private static final String GRANT_TYPE_PARAM = "grant_type";
    private static final class GrantType {
        private static final String AUTHORIZATION_CODE = "response";
        private static final String REFRESH_TOKEN = "refresh_token";
    }
    private static final String REFRESH_TOKEN_PARAM = "refresh_token";

    @RequestMapping(
            path = "/token",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody TokenResponse token(
         @RequestParam(name = GRANT_TYPE_PARAM, required = false) String grantType, // REQUIRED
         // for exchanging access token by authorization code
         @RequestParam(name = CODE_PARAM, required = false) String code, // REQUIRED
         @RequestParam(name = REDIRECT_URI_PARAM, required = false) String redirectUri, // REQUIRED
         @RequestParam(name = CLIENT_ID_PARAM, required = false) String clientId, // REQUIRED
         // for refreshing access token
         @RequestParam(name = REFRESH_TOKEN_PARAM, required = false) String refreshToken, // REQUIRED
         @RequestParam(name = SCOPE_PARAM, required = false) String scope // OPTIONAL
    ) {
        return null;
    }
}
