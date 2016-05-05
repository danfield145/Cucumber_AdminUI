package pageObject;


import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    protected String DEMO_URL = "https://demoapp.weconvene.com";

    //constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;}


    public LoginPage navigateToDemoSite() throws InterruptedException {

        driver.navigate().to(DEMO_URL);

        return new LoginPage(driver);
    }

    public void closeDriver(){
        driver.quit();
    }
}
