package org.personal.project.tests;

import lombok.extern.log4j.Log4j2;
import org.personal.project.steps.WeatherApiStep;
import org.testng.annotations.BeforeSuite;

@Log4j2
public class BaseTest {

    protected WeatherApiStep weatherApiStep = new WeatherApiStep();

    @BeforeSuite(alwaysRun = true)
    public void init() {
        log.info("Starting tests....");
    }
}
