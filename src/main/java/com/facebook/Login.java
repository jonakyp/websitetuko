package com.facebook;

import common.CommonInteractions;
import common.Readjson;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login {

    public WebDriver driver;
    private CommonInteractions common;
    public Login(WebDriver driver) {
        this.driver = driver;
        common = new CommonInteractions(driver);
    }

    By fb_username_field = By.id("email");
    By fb_password_field =By.id("pass");
    By login_btn = By.id("loginbutton");
    By post_btn = By.name("__CONFIRM__");
    By comment_text_field = By.xpath("//textarea[contains(@title,'Say something about this...')]");
    By news_feed_option = By.xpath("//*[contains(@aria-label='News Feed sort options']");
    By order_by_recent = By.xpath("(//span[contains(.,'Jonathan')])[2]");
    By fb_logo = By.xpath("(//span[contains(.,'Facebook')])[2]");


    public void fbLogin() throws IOException, ParseException {
        common.sendText(fb_username_field, Readjson.readjsonconfig("facebook","username"));
        common.sendText(fb_password_field,Readjson.readjsonconfig("facebook","password"));
        common.click(login_btn);
        common.elementPresent(post_btn);
    }

    public void postOnFB() throws IOException, ParseException {
        common.sendText(comment_text_field, Readjson.readjsonassert("fbcomment"));
        common.click(post_btn);
    }

    public void fbHomepage() throws IOException, ParseException {
        driver.get(Readjson.readjsonconfig("facebook","URI"));
        System.out.println(driver.getTitle());
        common.elementPresent(fb_logo);
//        String winHandleBefore = driver.getWindowHandle();
//        Set<String> handles = driver.getWindowHandles();
//
//        for (String winHandle : handles) {
//            if (!winHandle.equals(winHandleBefore)) {
//                driver.switchTo().window(winHandle);
//            }
        }



    public void newsFeedOption(){
//        WebElement element = driver.findElement(By.xpath("//p[contains(text(),+R+)]"));
//        common.click(news_feed_option);
        common.click(order_by_recent);
        common.click(news_feed_option);
    }


}
