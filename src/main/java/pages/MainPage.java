package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement buttonSearch;

    /*****************************************************************************/

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this); //'this' in this case, its parent class
    }

    public SignInPage clickSignInButton(){
        buttonSignIn.click();
        return new SignInPage(driver);
    }

    public SearchResultPage clickSearchButton(){
        buttonSearch.click();
        return new SearchResultPage(driver);
    }

    public MainPage editSearchField(String searchValue){
        searchField.sendKeys(searchValue);
        return this;
    }


}
