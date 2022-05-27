package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    private WebDriverWait myWait;

    public WebDriver getWebDriver() {
        return MyWebDriver.getWebDriver();
    }

    public WebDriverWait getMyWait() {
        if (myWait == null) {
            myWait = new WebDriverWait(getWebDriver(), 30, 1000);
        }
        return myWait;
    }

    public WebElement waitForElement(WebElement webElement) {
        return getMyWait().withMessage("Element cannot be located" + webElement).until(ExpectedConditions.visibilityOf(webElement));
    }

}
