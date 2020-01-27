package baseclass;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Tuko Website Cabalities setup")
public class CapabilitiesTest {

    public RemoteWebDriver driver;

    @Severity(SeverityLevel.BLOCKER)
    @BeforeClass
    public void setUp() throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.LINUX);
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setAcceptInsecureCerts(true);

        URL url = new URL(("http://localhost:4444/wd/hub/"));

        driver =new RemoteWebDriver(url,capabilities);
//
//        driver.get("https://www.tuko.co.ke/");

//        System.out.print("title is"+ driver.getTitle());

    }

    @Severity(SeverityLevel.MINOR)
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
