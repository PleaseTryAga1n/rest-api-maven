package org.personal.project.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.personal.project.clients.RestApiClient;
import org.personal.project.configs.Properties;
import org.personal.project.configs.PropertyHolder;

import java.util.Map;

@Log4j2
public class WeatherApiStep {

    Properties weatherAPIProperties = PropertyHolder.getWeatherAPIProperties();

    @Step("Getting weather for location")
    public Response getWeatherData(String location) {
        Response response = RestApiClient.get(
                Map.of(
                        "q", location
                ),
                Map.of(
                        "X-RapidAPI-Key", weatherAPIProperties.getWeatherAPI().getApiKey(),
                        "X-RapidAPI-Host", weatherAPIProperties.getWeatherAPI().getApiHost()
                ));
        log.info("Current location response: {}", response.getBody().asString());
        return response;
    }
}
