package org.homework;

import org.example.accuweather.weather.Weather;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.demo.accuweather.AccuweatherAbstractTest;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetWeatherFifteenDaysTest extends AccuweatherAbstractTest {

    @Test
    void getWeatherFifteenDays_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/15day/5")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(15, response.getDailyForecasts().size());
    }
}
