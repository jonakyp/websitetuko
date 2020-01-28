package com.tuko;

import common.AssertionHelpers;
import common.CommonInteractions;
import common.Readjson;
import common.PublicString;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;


public class Homepage {
    public WebDriver driver;
    private CommonInteractions common;
    public Homepage(WebDriver driver) {
        this.driver = driver;
        common = new CommonInteractions(driver);
    }


    By tuko_log_img = By.xpath("(//img[@alt='TUKO.co.ke'])[1]");
    By footer_adv_anchor = By.className("c-adv-anchor");
    By category_links = By.cssSelector(".c-header-menu__link");


    public void loadHomepage() throws IOException, ParseException {

        driver.get("https://www.tuko.co.ke/");
        common.elementPresent(tuko_log_img);
        common.elementPresent(footer_adv_anchor);
        PublicString.homepagewebtitle = driver.getTitle();
        AssertionHelpers.verifyText(PublicString.homepagewebtitle,Readjson.readjsonassert("tukotitle"));

    }

    public List<WebElement> listCategories(){
        return driver.findElements(category_links);
    }
}
