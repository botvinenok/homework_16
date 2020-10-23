import AccountData.Account;
import AccountData.AccountBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverType;
import utils.UtilCustom;
import utils.WebDriverFactory;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private static final String MAIN_PAGE_URL ="http://automationpractice.com";
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;
    public WebDriver driver;
    private Account account;

    @Before
    public void setup(){
        driver = WebDriverFactory.getDriver(DriverType.CHROME);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(MAIN_PAGE_URL);
        UtilCustom.sleepSecond(5);

        account = new AccountBuilder()
                .withFirstNameField("Gena")
                .withLastNameField("Vasiliysya")
                .withPhoneMobileField("454684515648")
                .withAddressField("street Gioolo")
                .withPostcodeField("252552")
                .withCityField("Kiev")
                .withAliasField("dfghuhdfsgfd")
                .build();
        mainPage = new MainPage(driver);
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        UtilCustom.sleepSecond(5);
        driver.close();
    }

    @Test
    public void registration() {
        signInPage = mainPage.clickSignInButton();
        signInPage.editEmailFieldCreateAcc();
        registrationPage = signInPage.clickCreateAccount();
        registrationPage.fillAllFieldsAndPressSRegistration(account);
    }
}
