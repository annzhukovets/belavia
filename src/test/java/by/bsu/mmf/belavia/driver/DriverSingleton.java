package by.bsu.mmf.belavia.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;


public class DriverSingleton {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    private DriverSingleton(){};


    public static WebDriver getDriver(){
        if (null == driver){

            driver = new FirefoxDriver();

            new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
                @Nullable
                @Override
                public Boolean apply(@Nullable WebDriver wd) {
                    return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
                }
            });

            logger.info("Browser started");
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
