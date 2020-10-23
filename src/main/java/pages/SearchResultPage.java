package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilCustom;

public class SearchResultPage {

    private WebDriver driver;

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement buttonList;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement buttonProceedToCheckout;

    /*****************************************************************************/

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SearchResultPage clickList(){
        buttonList.click();
        return this;
    }

    public SearchResultPage clickAddToCart(){
        buttonAddToCart.click();
        return this;
    }

    public SearchResultPage clickProceedToCheckout(){
        buttonProceedToCheckout.click();
        return this;
    }

    public ShoppingSummaryPage addBlouseToCart(){
        clickList().clickAddToCart().clickProceedToCheckout();
        return new ShoppingSummaryPage(driver);
    }

}
