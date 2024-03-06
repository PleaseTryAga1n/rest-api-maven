package org.personal.project.tests;

import org.junit.runner.RunWith;
import org.personal.project.assertions.WeatherAssertionsStep;
import org.personal.project.configs.ServiceConfigs;
import org.personal.project.configs.WeatherAPIProperties;
import org.personal.project.steps.WeatherApiStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WeatherAPIProperties.class, ServiceConfigs.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WeatherApiStep weatherApiStep;

    @Autowired
    WeatherAssertionsStep weatherAssertionsStep;

    @Autowired
    WeatherAPIProperties weatherAPIProperties;

    @BeforeSuite(alwaysRun = true)
    public void init() throws Exception {
        this.springTestContextPrepareTestInstance();
    }
}
