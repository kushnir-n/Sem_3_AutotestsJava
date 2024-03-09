package org.demo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/*
    Простой демо тест
 */
public class RestAssuredExampleTest {

    @Test
    void test() {
        given()
        .when().get("https://www.google.com/")
        .then().statusCode(200);
    }
}
