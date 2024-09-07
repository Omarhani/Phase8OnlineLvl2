package t;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModal;

public class T {


    @Test
    public void t1() throws FileNotFoundException {
        System.out.println(dataModal().URL);
    }



    @Test
    public void t2() throws FileNotFoundException {
        System.out.println(dataModal().Login.ValidCredentials.Username);
        System.out.println(dataModal().Login.ValidCredentials.Password);
    }

    @Test
    public void t3() throws FileNotFoundException {
        System.out.println(dataModal().Login.InvalidCredentials.InvalidUsername.Username);
        System.out.println(dataModal().Login.InvalidCredentials.InvalidUsername.Password);
    }

    @Test
    public void t4() throws FileNotFoundException {
        System.out.println(dataModal().Login.InvalidCredentials.InvalidPassword.Username);
        System.out.println(dataModal().Login.InvalidCredentials.InvalidPassword.Password);
    }

    @Test(dataProvider = "dataProviderFort5")
    public void t5(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] dataProviderFort5() throws FileNotFoundException {
        return dataModal().Login1;
    }
}
