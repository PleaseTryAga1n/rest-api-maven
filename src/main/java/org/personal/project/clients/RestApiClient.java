package org.personal.project.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.personal.project.constants.Endpoints.GET_CURRENT_WEATHER_URL;

@Component
public class RestApiClient {

    @Autowired
    RequestSpecification reqSpec;

    public synchronized Response get(Map<String, String> qParams, Map<String, String> headers) {
        return given(reqSpec)
                .queryParams(qParams)
                .headers(headers)
                .get(GET_CURRENT_WEATHER_URL);
    }
}
