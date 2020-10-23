package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DriverType;

public final class WebDriverFactory {


    public static WebDriver getDriver(DriverType type) {

        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver();
                return chromeDriver;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                //WebDriver firefoxDriver = new FirefoxDriver();
                //return firefoxDriver;

            case IE:
                WebDriverManager.iedriver().setup();
                //WebDriver ieDriver = new InternetExplorerDriver();
                //return ieDriver;

            default:
                throw new IllegalArgumentException("No implementation for provided driver type");
        }
    }
}
