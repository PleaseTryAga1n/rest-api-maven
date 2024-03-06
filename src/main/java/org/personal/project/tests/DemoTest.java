package org.personal.project.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {

    @DataProvider(parallel = true)
    public Object[][] locationDataProvider() {
        return new Object[][]{
                {"Paris", "France"},
                {"London", "United Kingdom"},
                {"Warsaw", "Poland"},
                {"Rome", "Italy"},
                {"Madrid", "Spain"},
                {"Lisbon", "Portugal"}
        };
    }

    @Issue("XXXX")
    @Test(groups = "all", dataProvider = "locationDataProvider")
    @Description("Test to verify current weather endpoint by city name")
    public void getCurrentWeatherTest(String cityName, String expectedCountry) {
        Response currWeatherResponse = weatherApiStep.getWeatherData(cityName);
        weatherAssertionsStep.checkCurrentWeatherResponse(currWeatherResponse, expectedCountry);
    }
}
