package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver {

   public enum DriverEnum{
        CHROME,FIREFOX
    }

    private static WebDriverWait driverWait;
    private static org.openqa.selenium.WebDriver driverWeb;

    public static org.openqa.selenium.WebDriver getDriver() {
        if (driverWeb == null) {
            throw new NullPointerException("You need to initialize the WebDriver!!!!");
        }
        return driverWeb;
    }

    public static void setDriverWeb(org.openqa.selenium.WebDriver driver) {
        WebDriver.driverWeb = driver;
    }

    public static void startDriver(DriverEnum driverEnum, int defaultTimeout) {
        switch (driverEnum) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                setDriverWeb(new ChromeDriver());
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                setDriverWeb(new FirefoxDriver());
                break;
            default:
                break;
        }

        setBrowserWait(new WebDriverWait(getDriver(), defaultTimeout));
        setMaximizeWindow();
    }

    public static void startDriver() {
        startDriver(DriverEnum.CHROME);
    }

    public static void startDriver(DriverEnum driverEnum) {
        startDriver(driverEnum, 30);
    }

    public static void setBrowserWait(WebDriverWait wait) {
        WebDriver.driverWait = wait;
    }

    public static void setMaximizeWindow() {
        WebDriver.driverWeb.manage().window().maximize();
    }

    public static void quitDriver() {
        if (driverWeb != null) {
            driverWeb.quit();
        }
    }

}
