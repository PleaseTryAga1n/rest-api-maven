package org.personal.project.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;

@UtilityClass
@Data
public class PropertyHolder {

    private static Properties weatherAPIProperties;

    @SneakyThrows
    public static synchronized Properties getWeatherAPIProperties() {
        if (weatherAPIProperties == null) {
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            om.findAndRegisterModules();
            weatherAPIProperties = om.readValue(new File("./src/main/resources/QA/QA.yml"), Properties.class);
        }
        return weatherAPIProperties;
    }
}