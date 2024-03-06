package org.personal.project.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import org.apache.http.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.personal.project.constants.Endpoints.WEATHER_API_BASE_URL;

@Data
@Configuration
@ComponentScan(basePackages = {"org.personal.project.*"})
public class ServiceConfigs {

    @Bean
    public RequestSpecification requestSpecification() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(WEATHER_API_BASE_URL);
        builder.setUrlEncodingEnabled(false);
        builder.addHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON.toString());
        builder.log(LogDetail.ALL);
        return builder.build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
