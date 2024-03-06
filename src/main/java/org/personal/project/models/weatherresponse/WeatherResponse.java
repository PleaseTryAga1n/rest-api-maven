package org.personal.project.models.weatherresponse;

import lombok.Data;
import org.personal.project.models.weatherresponse.current.Current;

@Data
public class WeatherResponse {
    private Location location;
    private Current current;
}
