package io.securera.authauth.endpoint.internal;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static io.securera.authauth.endpoint.Constants.*;

@Controller
public class AuthenticationController {

    /**
     * Show authentication page. Once user authenticates successfully, forward to a consent page which page
     * should show the user:
     * - resource owner
     * - client information
     * - scope information requested
     *
     * user can choose 'Allow' or 'Cancel'
     *
     * @param responseType
     * @param clientId
     * @param redictUri
     * @param scope
     * @param state
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(
            path = "/authenticate",
            method = RequestMethod.POST)
    public ModelAndView authenticate(@RequestParam(name = RESPONSE_TYPE_PARAM, required = false) String responseType, // REQUIRED
                               @RequestParam(name = CLIENT_ID_PARAM, required = false) String clientId, // REQUIRED
                               @RequestParam(name = REDIRECT_URI_PARAM, required = false) String redictUri, // OPTIONAL
                               @RequestParam(name = SCOPE_PARAM, required = false) String scope, // OPTIONAL
                               @RequestParam(name = STATE_PARAM, required = false) String state, // RECOMMENDED
                               @RequestParam(name = "username", required = false) String username,
                               @RequestParam(name = "password", required = false) String password,
                               HttpServletRequest httpServletRequest,
                               HttpSession httpSession,
                               ModelMap modelMap
    ) {
        // TODO authenticate user account

        httpSession.setAttribute("logined", true);
        httpSession.setAttribute("userId", "1");

        modelMap.put("clientName", "test client");
        modelMap.put("userName", username);
        modelMap.put("scope", scope);
        modelMap.put("query", httpServletRequest.getQueryString());

        return new ModelAndView(CONSENT_VIEW, modelMap); // show consent page
    }
}
