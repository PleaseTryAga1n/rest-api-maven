package org.personal.project.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpStatus;
import org.personal.project.models.weatherresponse.WeatherResponse;

import static org.assertj.core.api.Assertions.assertThat;

@UtilityClass
public class WeatherAssertionsStep {

    @Step("Checking weather")
    public static void checkCurrentWeatherResponse(Response actualResponse, String expectedCountry) {
        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        WeatherResponse weatherResponse = actualResponse.getBody().as(WeatherResponse.class);
        assertThat(weatherResponse.getLocation()).isNotNull();
        assertThat(weatherResponse.getLocation().getCountry()).isEqualTo(expectedCountry);
        //TODO: Implement many more checks when needed
    }
}
