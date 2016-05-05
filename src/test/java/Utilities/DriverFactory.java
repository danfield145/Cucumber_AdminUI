package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    private static DriverFactory driverFactory;

    private WebDriver driver;

    private DriverFactory(){

    }

    public static DriverFactory getInstance(){
        if(driverFactory == null){
            driverFactory = new DriverFactory();
        }
        return driverFactory;
    }

    public WebDriver getDriver(){
        if(driver == null){
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void destroyDriver(){

        driver.quit();
        driver = null;
    }

}
