package com.tuko.categories;

import com.tuko.Homepage;
import common.CommonInteractions;
import common.Readjson;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CategoriesCommonFunctions {

    public WebDriver driver;
    //    Actions actions;
    Homepage homepage;
    By story_links = By.className("c-article-card-no-border__headline-hover-inner");
    By share_article = By.xpath("//div[contains(@class,'l-article__share js-article-share l-article__share--top-fixed')]");
    By close_adv_btn = By.xpath("//div[@class='c-adv-anchor__close-btn js-adv-close-btn']");
    By footer_adv_anchor = By.className("c-adv-anchor");
    By facebook_link_btn = By.cssSelector("a.c-article-share-item:nth-child(1)");
    By fb_username_field = By.id("email");
    By tuko_log_img = By.xpath("(//img[@alt='TUKO.co.ke'])[1]");
    private CommonInteractions common;

    public CategoriesCommonFunctions(WebDriver driver) {
        this.driver = driver;
        common = new CommonInteractions(driver);
        homepage = new Homepage(driver);
//        actions = new Actions(driver);
    }

    public void selectNewsCategory(String categorykeyword) throws IOException, ParseException {

        List<WebElement> categories = homepage.listCategories();
        String contains_text = Readjson.readjsonassert(categorykeyword);
        for (WebElement category : categories) {
            if (category.getText().contains(contains_text)) {
//                System.out.println(category.getText());
                category.click();

            } else {
                System.out.println("category not present");
            }
        }
    }

    public void selectStoryLink() {
        List<WebElement> links = driver.findElements(story_links);
        Actions actions = new Actions(driver);
        WebElement elem = links.get(0);
        actions.click(elem).perform();
        common.elementPresent(share_article);
        System.out.println("story title is = " + driver.getTitle());
    }

    public void selectFacebooklink() {
        common.click(facebook_link_btn);
        driver.manage().timeouts().implicitlyWait(20,SECONDS);
        String winHandleBefore = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String winHandle : handles) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
        common.elementPresent(fb_username_field);
        System.out.println("Current Window title = " + driver.getTitle());

    }




}
