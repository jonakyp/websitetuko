package com.tuko;

import baseclass.CapabilitiesTest;
import com.tuko.categories.Education;
import io.qameta.allure.*;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Tuko Website")
@Feature("Education Page")
@Severity(SeverityLevel.CRITICAL)
@Listeners(TestListener.class)
@Owner("JB bot")
public class EducationTest extends CapabilitiesTest {

    @Test(priority = 1)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: Load tuko.co.ke Homepage")
    public void testHomepage() throws IOException {

        Homepage homepage = new Homepage(driver);
        try {
            homepage.loadHomepage();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: Load Education Page")
    public void testLoadEducationPage() throws IOException {
        Education education = new Education(driver);
        try {
            education.loadEducationPage();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: Select an Education Story and click on it")
    public void testLoadStroyLinks() {
        Education education = new Education(driver);
        education.loadStoryLinks();
    }

    @Test(priority = 4)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: User Clicks on Facebook Share icon")
    public void testClickFacebookLink() {
        Education education = new Education(driver);
        education.clickFacebookLink();
    }

    @Test(priority = 5)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: User logs in on facebook share window")
    public void testFacbooklogin() throws IOException {
        Education education = new Education(driver);
        try {
            education.facbooklogin();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: User posts the Education story on FB")
    public void testpostNewsonFb() throws IOException {
        Education education = new Education(driver);
        try {
            education.postNewsonFb();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 7)
    @Story("Story Name: Education Page Tests")
    @Description("Test Description: User Confirms story shared on FB is the right one")
    public void testConfirmNewsPost() throws IOException {
        Education education = new Education(driver);
        try {
            education.confirmNewsPost();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
