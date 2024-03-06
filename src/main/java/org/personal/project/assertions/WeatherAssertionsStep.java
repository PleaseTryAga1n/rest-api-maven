package org.personal.project.assertions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.personal.project.models.weatherresponse.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.*;

@Component
public class WeatherAssertionsStep {

    @Autowired
    ObjectMapper objectMapper;

    @Step("Checking weather")
    public void checkCurrentWeatherResponse(Response actualResponse, String expectedCountry) {
        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        WeatherResponse weatherResponse = actualResponse.getBody().as(WeatherResponse.class);
        assertThat(weatherResponse.getLocation()).isNotNull();
        assertThat(weatherResponse.getLocation().getCountry()).isEqualTo(expectedCountry);
        //TODO: Implement many more checks when needed
    }
}
