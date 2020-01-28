package com.facebook;

import com.tuko.categories.CategoriesCommonFunctions;
import common.AssertionHelpers;
import common.CommonInteractions;
import common.Readjson;
import common.PublicString;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Login {

    public WebDriver driver;
    By fb_username_field = By.id("email");
    By fb_password_field = By.id("pass");
    By login_btn = By.id("loginbutton");
    By post_btn = By.name("__CONFIRM__");
    By comment_text_field = By.xpath("//textarea[contains(@title,'Say something about this...')]");
    By profile_tab = By.xpath("(//span[contains(.,'Jonathan')])[2]");
    By fb_logo = By.xpath("(//span[contains(.,'Facebook')])[2]");
    By posted_msg = By.xpath("(//div[contains(@data-testid,'post_message')])[1]");
    By fb_story_title = By.xpath("(//a[contains(@rel,'noopener nofollow')])[3]");
    private CommonInteractions common;
    private CategoriesCommonFunctions commonFunctions;

    public Login(WebDriver driver) {
        this.driver = driver;
        common = new CommonInteractions(driver);
        commonFunctions = new CategoriesCommonFunctions(driver);
    }

    public void fbLogin() throws IOException, ParseException {
        common.sendText(fb_username_field, Readjson.readjsonconfig("facebook", "username"));
        common.sendText(fb_password_field, Readjson.readjsonconfig("facebook", "password"));
        common.click(login_btn);
        common.elementPresent(post_btn);
    }

    public void postOnFB() throws IOException, ParseException {
        common.sendText(comment_text_field, Readjson.readjsonassert("fbcomment"));
        common.click(post_btn);
        common.elementPresent(fb_logo);
    }

    public void fbHomepage() throws IOException, ParseException {
        driver.get(Readjson.readjsonconfig("facebook", "URI"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

    public void newsFeedVerify() throws IOException, ParseException {
        common.click(profile_tab);
        String posted_txt = common.getText(posted_msg);
        System.out.println("Post Comment is  " + posted_txt);
        AssertionHelpers.verifyText(posted_txt, Readjson.readjsonassert("fbcomment"));
        String st_fb = common.getText(fb_story_title);
        System.out.println("FB story is  " + st_fb);
        common.click(fb_story_title);
        String winHandleBefore = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String winHandle : handles) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
        //
        String storyfbtuko = driver.getTitle();
        AssertionHelpers.verifyText(storyfbtuko, PublicString.storylinktitle);

    }


}
