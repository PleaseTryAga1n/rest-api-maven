package org.personal.project.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.personal.project.clients.RestApiClient;
import org.personal.project.configs.WeatherAPIProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Log4j2
@Component
public class WeatherApiStep {

    @Autowired
    RestApiClient restApiClient;

    @Autowired
    WeatherAPIProperties weatherAPIProperties;

    @Step("Getting weather for location")
    public Response getWeatherData(String location) {
        Response response = restApiClient.get(
                Map.of(
                        "q", location
                ),
                Map.of(
                        "X-RapidAPI-Key", weatherAPIProperties.getApiKey(),
                        "X-RapidAPI-Host", weatherAPIProperties.getApiHost()
                ));
        log.info("Current location response: {}", response.getBody().asString());
        return response;
    }
}
