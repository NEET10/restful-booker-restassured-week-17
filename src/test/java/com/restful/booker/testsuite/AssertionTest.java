package com.restful.booker.testsuite;

import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/10")
                .then().statusCode(200);
    }


    @Test
    public void test02(){
        System.out.println("The First name value is : " + response.extract().path("firstname"));
    }


    }

