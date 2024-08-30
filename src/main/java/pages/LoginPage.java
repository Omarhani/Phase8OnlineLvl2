package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.name("email");

    private final By passwordField = By.name("password");

    private final By loginButton = By.cssSelector("[data-qa='login-button']");


    private void insertEmail(String email) {
        sendKeys(emailField,email,4);
    }

    private void insertPassword(String password) {
        sendKeys(passwordField,password,4);
    }

    private void clickOnLoginButton() {
        click(loginButton,3);
    }

    public void loginFeature(String email, String password){
        insertEmail(email);
        insertPassword(password);
        clickOnLoginButton();

    }
}
