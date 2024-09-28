package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModal;
import static utils.MethodHandles.myAssertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginLink();
        loginPage.loginFeature(
                dataModal().Login.ValidCredentials.Username,
                dataModal().Login.ValidCredentials.Password);
        String actualResult = loginPage.getValidationMessage();
        myAssertEquals(actualResult, "Hello");
    }

    @Test
    public void testSuccessfulLogin2() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginLink();
        loginPage.loginFeature(
                dataModal().Login.ValidCredentials.Username,
                dataModal().Login.ValidCredentials.Password);
    }
    @Test
    public void testSuccessfulLogin3() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginLink();
        loginPage.loginFeature(
                dataModal().Login.ValidCredentials.Username,
                dataModal().Login.ValidCredentials.Password);
    }
}
