package base;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static base.MyWebDriver.getWebDriver;

public class Helper {

    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView()", element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void scrollIntoView(WebElement element, boolean alignToTop){
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView("+alignToTop+")", element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Object[][] index(int bound) {
        Object[][] indexes = new Object[bound][1];
        for (int i = 0; i <bound; i++) {
            indexes[i][0] = i;

        }
        return indexes;
    }
}
