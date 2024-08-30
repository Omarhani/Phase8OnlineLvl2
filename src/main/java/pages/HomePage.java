package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver){
        super(driver);
    }

    private final By signUpAndLoginLink = By.partialLinkText("Signup / Login");

    public LoginPage clickOnSignUpAndLoginLink(){
        click(signUpAndLoginLink,6);
        return new LoginPage(driver);
    }
}
