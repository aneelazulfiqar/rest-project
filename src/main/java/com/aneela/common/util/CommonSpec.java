package com.aneela.common.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import com.aneela.features.authorization.AuthorizationDataFactory;
import com.aneela.common.config.ConfigManager;
import com.aneela.common.config.UriConfig;

import java.util.Map;

import static java.util.Collections.EMPTY_MAP;

@SuppressWarnings("unchecked")
public class CommonSpec{

    protected static final UriConfig configuration = ConfigManager.getUriConfig();

    protected static RequestSpecification setURI(String uri) {
        return new RequestSpecBuilder().setBaseUri(uri).build();
    }

    protected static RequestSpecification appRequestSpecification(String uri, Map<String, String> headers, Map<String, String> params) {
        return new RequestSpecBuilder()
                .addRequestSpecification(setURI(uri))
                .setContentType(ContentType.URLENC)
                .addHeaders(headers)
                .addFormParams(params != null ? params : EMPTY_MAP)
                .build();
    }

    protected static RequestSpecification appRequestSpecification(String uri, Object body) {
        return new RequestSpecBuilder()
                .addRequestSpecification(setURI(uri))
                .setContentType(ContentType.JSON)
                .addHeader(AuthorizationDataFactory.AUTHORIZATION,
                        AuthorizationDataFactory.BEARER + AuthorizationDataFactory.accessTokenValue)
                .setBody(((body != null) ? body: ""))
                .build();
    }

}
