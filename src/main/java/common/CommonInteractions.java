package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonInteractions {

    public WebDriver driver;
    WaitHelpers wait;

    public CommonInteractions(WebDriver driver) {
        this.driver = driver;
        wait = new WaitHelpers(driver);
    }


    //Click Method
    public void click(By elementBy) {
        wait.waitForElementVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void sendText(By elementBy, String value) {
        wait.waitForElementVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(value);
    }

    //Get Text
    public String getText(By elementBy) {
        wait.waitForElementVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Clear Text
    public void cleartext(By elementBy) {
        wait.waitForElementVisibility(elementBy);
        driver.findElement(elementBy).clear();
    }

    //element is displayed
    public void elementPresent(By elementBy) {
        wait.waitForElementVisibility(elementBy);
        driver.findElement(elementBy).isDisplayed();
    }

    //element invisibility
    public void elementInvisibility(By elementBy) {
        wait.waitForElementInvisibility(elementBy);
    }

}


