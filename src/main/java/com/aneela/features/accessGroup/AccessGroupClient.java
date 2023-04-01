package com.aneela.features.accessGroup;

import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import com.aneela.common.util.RestAssuredCrud;
import com.aneela.generated.model.AccessGroupResponse;

public class AccessGroupClient extends RestAssuredCrud {
    @Step
    public static AccessGroupResponse postAccessGroup(String siteId) {
        return post(AccessGroupSpec.createAccessGroup(siteId), HttpStatus.SC_OK).as(AccessGroupResponse.class);
    }
}
