package com.aneela.common.util;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssuredCrud {
    public static Response get(RequestSpecification requestSpecification, int responseCode) {
        return given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .statusCode(responseCode).
                extract().response();
    }

    public static Response post(RequestSpecification requestSpecification, int responseCode) {
        return given()
                .spec(requestSpecification)
                .when()
                .post()
                .then()
                .statusCode(responseCode).
                extract().response();
    }

    public static Response patch(RequestSpecification requestSpecification, int responseCode) {
        return given()
                .spec(requestSpecification)
                .when()
                .patch()
                .then()
                .statusCode(responseCode).
                extract().response();
    }
}