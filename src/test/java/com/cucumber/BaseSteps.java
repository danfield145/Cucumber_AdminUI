package com.cucumber;


import Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    public static WebDriver driver;

    protected BaseSteps(){
       this.getDriver();
    }


    protected WebDriver getDriver(){
        driver = DriverFactory.getInstance().getDriver();
        return driver;
    }
}
