package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignUpAndLoginLink();
        loginPage.loginFeature(
                dataModal().Login.ValidCredentials.Username,
                dataModal().Login.ValidCredentials.Password);
    }
}
