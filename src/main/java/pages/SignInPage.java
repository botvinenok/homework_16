package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilCustom;

public class SignInPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement fieldEmailCreateAcc;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement buttonCreateAcc;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private WebElement errorCreateAccMessage;

    /*****************************************************************************/

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public RegistrationPage clickCreateAccount(){
        buttonCreateAcc.click();
        return new RegistrationPage(driver);
    }

    public SignInPage editEmailFieldCreateAcc(){
        fieldEmailCreateAcc.sendKeys("den" + UtilCustom.random() + "@mail.ru");
        return this;
    }

}
