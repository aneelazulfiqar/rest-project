package com.aneela.base;

import com.aneela.features.authorization.AuthorizationClient;
import com.aneela.features.authorization.AuthorizationDataFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public SoftAssert softAssert = new SoftAssert();
    @BeforeClass(alwaysRun = true)
    public void beforeEachAppTestClass() {
        AuthorizationDataFactory.accessTokenValue = new AuthorizationClient().postCallToGetAuthorizationToken();
    }

    @AfterClass
    public void afterClass()
    {
        softAssert.assertAll();
    }
}
