package myproject.Day12;

import myproject.POMPages.SmartBearLogInPage;
import myproject.base.TestBase2;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.testng.annotations.Test;

public class C1_smartBearPOM extends TestBase2 {

    @Test
    public void TC1_SmartBearPositiveTestVerification(){
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("SmartBearUrl"));
        SmartBearLogInPage smartBearLogInPage= new SmartBearLogInPage();
        smartBearLogInPage.LoginForSmartBear(PropertiesReadingUtil.getProperties("SmartBear_userName"),
                PropertiesReadingUtil.getProperties("SmartBear_password"));

    }
}

