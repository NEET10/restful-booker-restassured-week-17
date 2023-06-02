package com.restful.booker.testsuite;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/10")
                .then().statusCode(200);
    }

    @Test
    public void test01() {
        String name = response.extract().path("firstname");
        System.out.println("The First name value is : " + name);
    }

    @Test
    public void test02() {
        String lastname = response.extract().path("lastname");
        System.out.println("The Last name value is : " + lastname);
    }

    @Test
    public void test03() {

        System.out.println("When First name is susan then booking date checkout is : " + response.extract().path("bookingdates.checkout"));
    }

    @Test
    public void test04() {
        List<String> allNames = response.extract().path("firstname");
        System.out.println("The First names : " + allNames);
    }

    @Test
    public void test05() {
        List<Integer> allId = response.extract().path("id");
        System.out.println(allId);
    }

}
