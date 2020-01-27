package com.tuko;

import baseclass.CapabilitiesTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private String testResult;

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }
//
//    @Attachment(value = "{0}", type = "text/html")
//    public static String attachHtml(String html) {
//        return html;
//    }

    private String getTestResult() {
        return testResult;
    }

    private void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Execution Starts ------->" + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test Suite Execution Finished ------->" + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test Starts ------->" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test PASSED ------->" + result.getName());
        setTestResult("Congrats test has PASSED ");
        saveTextLog(getTestResult());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED ------->" + result.getName());
        System.out.println("Kindly check the screenshot");
        setTestResult(" FAILED " + TestName(result));


        Object currentClass = result.getInstance();
        WebDriver driver = ((CapabilitiesTest) currentClass).getDriver();

        if (driver != null) {
            saveScreenshotPNG(driver);
        }
        saveTextLog(getTestResult() + "****KO Screenshot taken!!****");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        /* TODO */
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /* TODO */
    }

    private String TestName(ITestResult result) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String fileName;
        fileName = dtf.format(localDate) + "___" + result.getEndMillis() + "___" +
                result.getTestClass().getRealClass().getSimpleName() + "___" + result.getName();
        return fileName;
    }
}
