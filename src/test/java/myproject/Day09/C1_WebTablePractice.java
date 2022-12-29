package myproject.Day09;

import myproject.utilities.SmartBearUtils;
import myproject.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class C1_WebTablePractice {

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void TC1_Login(){
        SmartBearUtils.loginForSmartbearUtil(driver);
        //verify that we login to SmartBear
        Assert.assertEquals(driver.getTitle(),"Web Orders");
    }

    @Test(dataProvider = "StreetDataLibrary")
    public void TC2_streetverification(String streetName){
        //verify that given street exist on the web table
        SmartBearUtils.loginForSmartbearUtil(driver);
        SmartBearUtils.verfyStreet(driver,streetName);

    }

    @DataProvider(name = "StreetDataLibrary")
    public static Object [][] test(){
        return new Object[][]{
                {"55, Washington ave"},
                {"17, Park Avenue"},
                {"3, Garden st."}
        };
    }
}
