import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.SearchResultPage;
import pages.ShoppingSummaryPage;
import utils.DriverType;
import utils.UtilCustom;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ResultSearchTest {

    private static final String MAIN_PAGE_URL ="http://automationpractice.com";
    private MainPage mainPage;
    private SearchResultPage searchPage;
    private ShoppingSummaryPage cartPage;
    public WebDriver driver;

    @Before
    public void setup(){
        driver = WebDriverFactory.getDriver(DriverType.CHROME);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(MAIN_PAGE_URL);
        UtilCustom.sleepSecond(5);
        mainPage = new MainPage(driver);
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        UtilCustom.sleepSecond(5);
        driver.close();
    }

    @Test
    public void searchProduct() {
        searchPage = mainPage.editSearchField("Blouse").clickSearchButton();
        cartPage = searchPage.addBlouseToCart();
        Assert.assertTrue(cartPage.checkPrices());
        Assert.assertEquals("56.00", cartPage.checkFieldTotalPrice());
        Assert.assertEquals("54.00", cartPage.checkFieldTotalProduct());
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
