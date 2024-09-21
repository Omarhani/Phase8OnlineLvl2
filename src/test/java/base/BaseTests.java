package base;

import data.DataModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import static reader.ReadDataFromJson.dataModal;

public class BaseTests {

    WebDriver driver;

    protected HomePage homePage;

    ChromeOptions chromeOptions;

    FirefoxOptions firefoxOptions;

    UtilsTests utilsTests;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional ("chrome")String browser){
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Parameters("browser")
    public void setUpBrowser(@Optional ("chrome") String browser){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void afterMethod(Method method) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
    }
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        driver.get(dataModal().URL);
        ScreenRecorderUtil.startRecord(method.getName());
    }


}
