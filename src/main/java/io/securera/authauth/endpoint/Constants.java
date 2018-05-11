package io.securera.authauth.endpoint;

public final class Constants {
    public static final class ResponseType {
        public static final String CODE = "code";
        public static final String TOKEN = "token";
    }

    public static final String RESPONSE_TYPE_PARAM = "response_type";
    public static final String RESPONSE_TYPES_DELIMITER = "%x20";

    public static final String CLIENT_ID_PARAM = "client_id";
    public static final String REDIRECT_URI_PARAM = "redirect_uri";
    public static final String SCOPE_PARAM = "scope";

    public static final String STATE_PARAM = "state"; // RECOMMENDED
    public static final String CODE_PARAM = "code";
    public static final String TOKEN_PARAM = "token";

//    public static final String AUTHENTICATION_VIEW = "authenticate";
    public static final String CONSENT_VIEW = "consent";
}
