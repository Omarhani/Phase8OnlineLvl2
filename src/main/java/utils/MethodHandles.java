package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class MethodHandles {
    protected WebDriver driver;

    WebDriverWait wait;
    Select select;

    Actions actions;
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
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time); // Stale
                addBorderToElement(driver, webElement(locator)); // Stale
                webElement(locator).click(); // Stale
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clear(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time); // Stale
                addBorderToElement(driver, webElement(locator)); // Stale
                webElement(locator).clear(); // Stale
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void submit(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time); // Stale
                addBorderToElement(driver, webElement(locator)); // Stale
                webElement(locator).submit(); // Stale
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void sendKeys(By locator, String text, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                webElement(locator).sendKeys(text);
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }

    }

    protected boolean isDisplayed(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                flag = webElement(locator).isDisplayed();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected boolean isSelected(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isSelected();
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected boolean isEnabled(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isEnabled();
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected String getText(By locator, int time) {
        String text = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                text = webElement(locator).getText();
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return text;
    }

    protected void selectByVisibleText(By locator, String visibleText) {
        for (int i = 0; i < 5; i++) {
            try {
                select = new Select(webElement(locator));
                select.selectByVisibleText(visibleText);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByValue(By locator, String value) {
        for (int i = 0; i < 5; i++) {
            try {
                select = new Select(webElement(locator));
                select.selectByValue(value);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByIndex(By locator, int index) {
        for (int i = 0; i < 5; i++) {
            try {
                select = new Select(webElement(locator));
                select.selectByIndex(index);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    protected void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    protected String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    protected void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    protected void switchToFrame(By locator) {
        for (int i = 0; i < 5; i++) {
            try {
                driver.switchTo().frame(webElement(locator));
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    protected void clickWithActions(By locator) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.click(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clickWithActions() {
        actions = new Actions(driver);
        actions.click().build().perform();
    }

    protected void doubleClick(By locator) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.doubleClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void contextClick(By locator) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.contextClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clickAndHold(By locator) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.clickAndHold(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clickAndHold() {
        actions = new Actions(driver);
        actions.clickAndHold().build().perform();
    }

    protected void moveToElement(By locator) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.moveToElement(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void dragAndDrop(By src, By target) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.dragAndDrop(webElement(src), webElement(target)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void release(By locator) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                actions.release(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void doubleClick() {
        actions = new Actions(driver);
        actions.doubleClick().build().perform();
    }

    protected void release() {
        actions = new Actions(driver);
        actions.release().build().perform();
    }

    protected void contextClick() {
        actions = new Actions(driver);
        actions.contextClick().build().perform();
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

    private void setSteps() {
        test.info(getMethodName());
    }

    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '7px solid blue'", element);
    }

    public static void myAssertEquals(Object actualResult, Object expectedResult) {
        test.info(MarkupHelper.createLabel("------------------------ Actual Result ------------------------", ExtentColor.GREY));
        test.info(actualResult.toString());

        test.info(MarkupHelper.createLabel("------------------------ Expected Result ------------------------", ExtentColor.GREY));
        test.info(expectedResult.toString());

        assertEquals(actualResult, expectedResult);
    }

}
