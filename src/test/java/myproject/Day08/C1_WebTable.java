package myproject.Day08;

import myproject.utilities.BrowserUtils;
import myproject.utilities.SmartBearUtils;
import myproject.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class C1_WebTable {
    //    Smartbear software street verification
    //       1. Open browser and login to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //       2. Click on View all orders
    //       3. Verify Mark Smith has street as  "9, Maple Valley"

    WebDriver driver;
    @BeforeTest
    public void SetUp(){
        driver= WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
    public void closing(){
        BrowserUtils.wait(4);
        driver.close();
    }

    @Test
    public void TC1_StreetVerification(){
        SmartBearUtils.loginForSmartbearUtil(driver);
//        2. Click on View all orders
        driver.findElement(By.linkText("View all orders")).click();
//       3. Verify Mark Smith has street as  "9, Maple Valley"
        WebElement Street= driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[3]/td[6]"));
        System.out.println("Mark Street name: "+Street.getText());
        String Actual = Street.getText();
        String Expected="9, Maple Valley";
        Assert.assertEquals(Actual,Expected,"Street name verification has failed");
        System.out.println("\"Street name verification has passed\"");
    }



}
