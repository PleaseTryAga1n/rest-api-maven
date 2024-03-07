package org.personal.project.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpHeaders;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.personal.project.constants.Endpoints.GET_CURRENT_WEATHER_URL;
import static org.personal.project.constants.Endpoints.WEATHER_API_BASE_URL;

@UtilityClass
public class RestApiClient {

    public static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri(WEATHER_API_BASE_URL)
                    .setUrlEncodingEnabled(false)
                    .addHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON.toString())
                    .log(LogDetail.ALL).build();

    public static Response get(Map<String, String> qParams, Map<String, String> headers) {
        return given(REQUEST_SPECIFICATION)
                .queryParams(qParams)
                .headers(headers)
                .get(GET_CURRENT_WEATHER_URL);
    }
}
