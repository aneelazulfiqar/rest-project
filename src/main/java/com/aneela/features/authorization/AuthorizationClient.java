package com.aneela.features.authorization;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import com.aneela.common.util.RestAssuredCrud;

public class AuthorizationClient extends RestAssuredCrud {

    @Step
    public String postCallToGetAuthorizationToken() {
        Response response = post(AuthorizationSpec.buildAuthorizationRequestSpec(), HttpStatus.SC_OK);
        return response.path(AuthorizationDataFactory.ACCESS_TOKEN_KEY).toString();
    }
}
