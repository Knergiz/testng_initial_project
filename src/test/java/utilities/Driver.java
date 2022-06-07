package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {

            // EDIT BROWSER HERE!!!
            // - change the string to browser of choice
            String browser = "chrome";
            // EDIT BROWSER HERE!!!


            switch (browser){

                //Chrome
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                //Firefox
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new NotFoundException("Browser is not defined properly");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        }
        return driver;
    }



    public static void quitDriver(){
        if (driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }

}
