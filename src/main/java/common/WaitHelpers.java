package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelpers {
    public WebDriver driver;
    WaitHelpers(WebDriver driver){
        this.driver=driver;
    }

    void waitForElementVisibility(By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    void waitForElementClickable(By elementBy, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    void waitForElementInvisibility(By elementBy) {
        WebDriverWait wait =  new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    void  waitForElementsVisibility(By elementBy) {
        WebDriverWait wait =  new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }
}
