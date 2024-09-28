package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class MethodHandles {
    protected WebDriver driver;

    WebDriverWait wait;
    static ExtentReports extent;

    static ExtentTest test;


    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    protected void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    protected void click(By locator, int time) {
        explicitWait(locator, time);
        webElement(locator).click();
        setSteps();
        addBorderToElement(driver,webElement(locator));
    }

    protected void sendKeys(By locator, String text, int time) {
        explicitWait(locator, time);
        webElement(locator).sendKeys(text);
        setSteps();
        addBorderToElement(driver,webElement(locator));
    }

    protected String getText(By locator, int time){
        explicitWait(locator, time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        return webElement(locator).getText();
    }
    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }

    private void setSteps(){
        test.info(getMethodName());
    }

    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '7px solid blue'", element);
    }

    public static void myAssertEquals(Object actualResult, Object expectedResult){
        test.info(MarkupHelper.createLabel("------------------------ Actual Result ------------------------", ExtentColor.GREY));
        test.info(actualResult.toString());

        test.info(MarkupHelper.createLabel("------------------------ Expected Result ------------------------", ExtentColor.GREY));
        test.info(expectedResult.toString());

        assertEquals(actualResult, expectedResult);
    }

}
