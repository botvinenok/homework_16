package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingSummaryPage {


    private WebDriver driver;

    @FindBy(xpath = "//a[@class='cart_quantity_up btn btn-default button-plus']")
    private WebElement buttonAddQTY;

    @FindBy(xpath = "//td[@class='price']")
    private List<WebElement> listPrices;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement buttonDeleteProduct;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement alertMsgEmptyCart;

    @FindBy(xpath = "//tr[@class='cart_total_price']//td[@id='total_price_container']")
    private WebElement fieldTotalPrice;

    @FindBy(xpath = "//tr[@class='cart_total_price']//td[@id='total_product']")
    private WebElement fieldTotalProducts;

    /*****************************************************************************/

    public ShoppingSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ShoppingSummaryPage clickAddProduct(){
        buttonAddQTY.click();
        return this;
    }

    public String checkFieldTotalPrice(){
        return fieldTotalPrice.getText().trim().replace("$", "");
    }

    public String checkFieldTotalProduct(){
       return fieldTotalProducts.getText().trim().replace("$", "");
    }

    public boolean checkPrices(){
        clickAddProduct();
        try {
            for(WebElement price : listPrices){
                Double.parseDouble(price.getText().trim().replace("$", ""));
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private ShoppingSummaryPage clickRemoveProducts(){
        buttonDeleteProduct.click();
        return this;
    }

    public boolean isCartEmpty(){
        clickRemoveProducts();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-warning']")));
        return alertMsgEmptyCart
                .getText().trim().toLowerCase()
                .contains("empty") ? true: false;
    }


}
