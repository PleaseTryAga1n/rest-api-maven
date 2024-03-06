package org.personal.project.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ComponentScan(basePackages = {"org.personal.project.*"})
public class WeatherAPIProperties {
    @Value("${weatherApi.apiKey}")
    private String apiKey;
    @Value("${weatherApi.apiHost}")
    private String apiHost;
}
