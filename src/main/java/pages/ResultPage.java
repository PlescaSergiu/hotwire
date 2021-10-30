package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basepage.BasePage;
import webdriver.WebDriver;

import java.util.List;

public class ResultPage extends BasePage {

    private org.openqa.selenium.WebDriver webDriver;

    @FindAll({@FindBy(css = ".cf > article")})
    private List<WebElement> resultList;

    public ResultPage(org.openqa.selenium.WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public int getSearchResultListSize() {
        WebDriverWait webDriverWait = new WebDriverWait(WebDriver.getDriver(), 20);
        webDriverWait.until(title -> title.findElement(By.id("hotelResultTitle")));

        return resultList.size();
    }
}
