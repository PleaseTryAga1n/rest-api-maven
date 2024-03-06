package org.personal.project.models.weatherresponse.current;

import lombok.Data;

@Data
public class Condition {
    private String text;
    private String icon;
    private int code;
}
