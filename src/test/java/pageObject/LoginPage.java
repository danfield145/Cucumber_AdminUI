package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    // element selectors
    private final By EMAIL_ADDRESS = By.cssSelector("[name=\"LoginEmail\"][type=\"email\"]");
    private final By PASSWORD = By.cssSelector("[type=\"password\"][name=\"LoginPW\"]");
    private final By LOGIN = By.cssSelector("[type=\"submit\"].wc-btn");
    private final By LOGIN_ERROR_PROMPT = By.cssSelector("[data-ng-show=\"login.error\"]");

    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //page interaction methods
    public LoginPage setEmailAddress(String email){

        WebElement inputEmailAddress = driver.findElement(EMAIL_ADDRESS);
        inputEmailAddress.sendKeys(email);

        return new LoginPage(driver);
    }

    public LoginPage setPassword(String password){

        WebElement inputPassword = driver.findElement(PASSWORD);
        inputPassword.sendKeys(password);

        return new LoginPage(driver);
    }

    public DashboardPage submitCredentials(){

        WebElement btnLogin = driver.findElement(LOGIN);
        btnLogin.click();

        return new DashboardPage(driver);
    }

    public LoginPage submitCredentialsExpectingError(){

        WebElement btnLogin = driver.findElement(LOGIN);
        btnLogin.click();

        return new LoginPage(driver);
    }

    public String getLoginErrorMessage() throws InterruptedException {

            WebElement loginErrorElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_ERROR_PROMPT));

        return loginErrorElement.getText();
    }

    public String getPageTilte(){
        return driver.getTitle();
    }

    public String getPageName() throws InterruptedException {

        //WebElement Login = driver.findElement(LoginSelector);

        WebElement Login = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(LOGIN));

        String pageName = "unknown page";

        if(Login.isDisplayed()){
            pageName = "Login Page";
        }
        return pageName;
    }
}