package com.tuko;

import baseclass.CapabilitiesTest;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Tuko Website")
@Feature("Homepage")
@Severity(SeverityLevel.CRITICAL)
@Listeners(TestListener.class)
@Owner("JB bot")
public class HomepageTest extends CapabilitiesTest {

    @Test
    @Story("Story Name: Homepage Access Tests")
    @Description("Test Description: Load tuko.co.ke Homepage")
    public void testHomepage() throws IOException {

        Homepage homepage = new Homepage(driver);
        try {
            homepage.loadHomepage();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        homepage.listCategories();


    }
}
