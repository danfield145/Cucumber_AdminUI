package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage extends BasePage {

    // element selectors
    private final By DASHBOARD_TITLE = By.cssSelector(".wc-title-inner");


    //constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    //methods
    public String getSectionTitle() throws InterruptedException {

        WebElement sectionTitle = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(DASHBOARD_TITLE));

        return sectionTitle.getText();
    }
}