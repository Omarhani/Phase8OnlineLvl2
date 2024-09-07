package base;

import data.DataModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModal;

public class BaseTests {

    WebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void goHome() throws FileNotFoundException {
        driver.get(dataModal().URL);
    }


}
