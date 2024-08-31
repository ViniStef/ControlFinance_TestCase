package ControlFinanceTest;

import org.openqa.selenium.WebDriver;
import org.mockito.Mockito;
import ControlFinance.WebDriverProvider;

public class MockWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver getWebDriver() {
        return Mockito.mock(WebDriver.class);
    }
}