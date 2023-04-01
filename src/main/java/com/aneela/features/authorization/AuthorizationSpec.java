package com.aneela.features.authorization;

import com.aneela.common.util.CommonSpec;
import io.restassured.specification.RequestSpecification;


public class AuthorizationSpec extends CommonSpec {
    public static RequestSpecification buildAuthorizationRequestSpec() {
        return CommonSpec.appRequestSpecification(
                configuration.authorizationUri(),
                AuthorizationDataFactory.authorizationHeader(),
                AuthorizationDataFactory.authorizationBody()
        );
    }

}
