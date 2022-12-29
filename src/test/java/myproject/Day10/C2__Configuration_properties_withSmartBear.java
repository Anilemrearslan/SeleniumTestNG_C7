package myproject.Day10;

import myproject.base.TestBase;
import myproject.utilities.PropertiesReadingUtil;
import myproject.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class C2__Configuration_properties_withSmartBear extends TestBase {
//open chrome browser
//go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//click on box which belongs "charles Dodgeson"
//click on delete button
//verify if charles deleted from the list

    @Test
    public void TC1_verifyDelete(){
        //go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get(PropertiesReadingUtil.getProperties("SmartBearUrl"));
        SmartBearUtils.loginForSmartbearUtil(driver);
        //click on box which belongs "charles Dodgeson"
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        //verify if charles deleted from the list
        SmartBearUtils.verifyName(driver,"Charles Dodgeson");

        List<WebElement> ListOfNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        for (WebElement eachName:ListOfNames){
            Assert.assertFalse(eachName.getText().equals("Charles Dodgeson"),"assert failed,\"Charles Dodgeson\" didn't deleted");
        }
        System.out.println("verification has passed, \"Charles Dodgeson\" was deleted");

        SmartBearUtils.verifyName2(driver,"Charles Dodgeson");
    }



}
