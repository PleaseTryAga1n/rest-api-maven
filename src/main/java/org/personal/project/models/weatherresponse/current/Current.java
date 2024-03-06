package org.personal.project.models.weatherresponse.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Current {
    @JsonProperty("last_updated_epoch")
    private long lastUpdatedEpoch;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("temp_c")
    private double tempC;
    @JsonProperty("temp_f")
    private double tempF;
    @JsonProperty("is_day")
    private byte isDay;
    private Condition condition;
    @JsonProperty("wind_mph")
    private double windMPH;
    @JsonProperty("wind_kph")
    private double windKPH;
    @JsonProperty("wind_degree")
    private int windDegree;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("pressure_mb")
    private double pressureMB;
    @JsonProperty("pressure_in")
    private double pressureIn;
    @JsonProperty("precip_mm")
    private double precipMM;
    @JsonProperty("precip_in")
    private double precipIn;
    private int humidity;
    private int cloud;
    @JsonProperty("feelslike_c")
    private double feelslikeC;
    @JsonProperty("feelslike_f")
    private double feelslikeF;
    @JsonProperty("vis_km")
    private double visKM;
    @JsonProperty("vis_miles")
    private double visMiles;
    private double uv;
    @JsonProperty("gust_mph")
    private double gustMPH;
    @JsonProperty("gust_kph")
    private double gustKPH;
}
