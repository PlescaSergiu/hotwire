package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import webdriver.WebDriver;

public class BaseUiAutomation {

    @BeforeTest
    public void startDriver(){
        WebDriver.startDriver(WebDriver.DriverEnum.CHROME);
    }

    @AfterTest
    public void closeDriver(){
        WebDriver.quitDriver();
    }
}
