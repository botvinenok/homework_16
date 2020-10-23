package pages;

import AccountData.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;
    private Account account;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcode;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement phoneMobile;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement alias;

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement buttonRegister;

    /*****************************************************************************/

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private RegistrationPage fillFirstNameField(String value){
        firstName.sendKeys(value);
        return this;
    }

    private RegistrationPage fillLastNameField(String value){
        lastName.sendKeys(value);
        return this;
    }

    private RegistrationPage fillAddressField(String value){
        address.sendKeys(value);
        return this;
    }

    private RegistrationPage fillCityField(String value){
        city.sendKeys(value);
        return this;
    }

    private RegistrationPage fillPostcodeField(String value){
        postcode.sendKeys(value);
        return this;
    }

    private RegistrationPage fillPhoneMobileField(String value){
        phoneMobile.sendKeys(value);
        return this;
    }

    private RegistrationPage fillAliasField(String value){
        alias.sendKeys(value);
        return this;
    }

    private RegistrationPage clickButtonRegister(){
        buttonRegister.click();
        return this;
    }

    public void fillAllFieldsAndPressSRegistration(Account account){
        fillFirstNameField(account.getFirstName());
        fillLastNameField(account.getLastName());
        fillAddressField(account.getAddress());
        fillCityField(account.getCity());
        fillPhoneMobileField(account.getPhoneMobile());
        fillPostcodeField(account.getPostcode());
        fillAliasField(account.getAlias());
        clickButtonRegister();
    }

}
