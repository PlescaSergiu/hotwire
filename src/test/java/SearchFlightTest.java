import base.BaseUiAutomation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultPage;
import webdriver.WebDriver;

public class SearchFlightTest extends BaseUiAutomation {

    private HomePage homePage;
    private ResultPage resultPage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(WebDriver.getDriver());
        resultPage = new ResultPage(WebDriver.getDriver());
    }

    @Test(testName = "Test Qiagen")
    public void searchFlight() {
        homePage.openHomePage();
        homePage.selectBundlesSearch();
        homePage.addCarToBundlesSearch();
        homePage.selectFlightFromTo("SFO", "LAX");
        homePage.selectDepartingAndReturningDate(1, 20);
        homePage.selectDepartingTime("Evening", "Morning");
        homePage.clickOnFindADealBtn();

        Assert.assertTrue(resultPage.getSearchResultListSize() > 1);
    }
}
