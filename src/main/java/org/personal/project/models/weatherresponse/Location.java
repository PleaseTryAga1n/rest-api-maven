package org.personal.project.models.weatherresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    private String name;
    private String region;
    private String country;
    private String lat;
    private String lon;
    @JsonProperty("tz_id")
    private String tzId;
    @JsonProperty("localtime_epoch")
    private String localtimeEpoch;
    private String localtime;
}
