package com.tuko.categories;

import com.facebook.Login;
import common.AssertionHelpers;
import common.CommonInteractions;
import common.Readjson;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Education {

    public WebDriver driver;
    By education_text = By.xpath("//span[@class='c-section-headline__text'][contains(.,'Education')]");
    private CommonInteractions common;
    private Login fb;
    private CategoriesCommonFunctions categoriesCommonFunctions;

    public Education(WebDriver driver) {
        this.driver = driver;
        common = new CommonInteractions(driver);
        categoriesCommonFunctions = new CategoriesCommonFunctions(driver);
        fb = new Login(driver);

    }

    public void loadEducationPage() throws IOException, ParseException {

        categoriesCommonFunctions.selectNewsCategory("edutabcontains");
        common.elementPresent(education_text);
        String edu_title = driver.getTitle();
        System.out.println(edu_title);
        AssertionHelpers.verifyText(edu_title, Readjson.readjsonassert("educationtitle"));
    }

    public void loadStoryLinks() {

        categoriesCommonFunctions.selectStoryLink();
    }

    public void clickFacebookLink() {

        categoriesCommonFunctions.selectFacebooklink();

    }

    public void facbooklogin() throws IOException, ParseException {

        fb.fbLogin();
    }

    public void postNewsonFb() throws IOException, ParseException {

        fb.postOnFB();
    }

    public void confirmNewsPost() throws IOException, ParseException {
        fb.fbHomepage();
        fb.newsFeedOption();

    }


}
