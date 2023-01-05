package myproject.Day12;

import com.github.javafaker.Faker;
import myproject.POMPages.SmartBearLogInPage;
import myproject.base.TestBase2;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C2_SmartBearNegative extends TestBase2 {
    //enter invalid credentials
    //verify that you get error message

    @Test
    public void TC1_InvalidUserCredentials(){
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("SmartBearUrl"));
        SmartBearLogInPage smartBearLogInPage= new SmartBearLogInPage();
        Faker faker = new Faker();
        smartBearLogInPage.LoginForSmartBear(faker.name().username(),faker.internet().password());

        String expectedMessage ="Invalid Login or Password.";
        String actualMessage = smartBearLogInPage.getStatusMessage();

        Assert.assertEquals(expectedMessage,actualMessage,"verification has failed, user able to login.");
        System.out.println("verification has passed, user is unable to login.");
    }
}
