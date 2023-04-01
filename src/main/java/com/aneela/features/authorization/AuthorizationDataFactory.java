package com.aneela.features.authorization;

import com.aneela.features.authorization.model.Authorization;
import com.aneela.common.config.AuthorizationConfig;
import com.aneela.common.config.ConfigManager;

import java.util.Map;


public class AuthorizationDataFactory {

    private static final AuthorizationConfig CONFIGURATION = ConfigManager.getAuthorizationConfig();
    private static final String GRANT_TYPE = "password";
    private static final String SCOPE = "user_api.full_access";
    public static final String USERNAME = CONFIGURATION.getUsername();
    private static final String SECRET_PASSWORD = CONFIGURATION.getPassword();
    private static final String SECRET_AUTHORIZATION_TOKEN = CONFIGURATION.getAuthorizationToken();
    public static final String ACCESS_TOKEN_KEY = "access_token";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static String accessTokenValue;


    public static Map<String, String> authorizationBody() {
        return Authorization
                .builder()
                .grant_type(GRANT_TYPE)
                .scope(SCOPE)
                .username(USERNAME)
                .password(SECRET_PASSWORD)
                .build().toMap();
    }

    public static Map<String, String> authorizationHeader() {
        return Map.of(AUTHORIZATION,
                "Basic" + " " + SECRET_AUTHORIZATION_TOKEN);
    }

}
