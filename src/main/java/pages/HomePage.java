package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.basepage.BasePage;

import java.time.LocalDate;

public class HomePage extends BasePage {

    private WebDriver webDriver;

    @FindBy(css = "div[data-bdd='farefinder-option-bundles']")
    private WebElement bundlesSearchButton;

    @FindBy(className = "submit-button")
    private WebElement findADealBtn;

    @FindBy(css = "[data-bdd='farefinder-package-origin-location-input']")
    private WebElement flyFrom;

    @FindBy(css = "[data-bdd='farefinder-package-destination-location-input']")
    private WebElement flyTo;

    @FindBy(css = "[data-bdd='farefinder-package-startdate-input']")
    private WebElement departingDate;

    @FindBy(css = "[data-bdd='farefinder-package-enddate-input']")
    private WebElement returningDate;

    @FindBy(css = "[data-bdd='farefinder-package-pickuptime-input']")
    private WebElement departingTime;

    @FindBy(css = "[data-bdd='farefinder-package-dropofftime-input']")
    private WebElement returningTime;

    @FindBy(css = "[data-bdd='farefinder-package-bundleoption-car']")
    private WebElement selectCar;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void selectBundlesSearch() {
        bundlesSearchButton.click();
    }

    public void selectDepartingTime(String departingTimeInput, String retuningTimeInput) {
        new Select(departingTime).selectByVisibleText(departingTimeInput);
        new Select(returningTime).selectByVisibleText(retuningTimeInput);
    }

    public void selectFlightFromTo(String flyFrom, String flyTo) {
        this.flyFrom.sendKeys(flyFrom + Keys.ENTER);
        this.flyTo.sendKeys(flyTo + Keys.ENTER);
    }

    public void selectDepartingAndReturningDate(int departingInDays, int returningInDays) {
        LocalDate dateNow = LocalDate.now();

        String departingDate = dateNow.plusDays(departingInDays).toString();
        String returningDate = dateNow.plusDays(returningInDays).toString();

        this.departingDate.sendKeys(departingDate);
        this.returningDate.sendKeys(returningDate);
    }

    public void clickOnFindADealBtn() {
        findADealBtn.click();
    }

    public void addCarToBundlesSearch() {
        selectCar.click();
    }

    public void openHomePage() {
        webDriver.get(URL);
    }
}
