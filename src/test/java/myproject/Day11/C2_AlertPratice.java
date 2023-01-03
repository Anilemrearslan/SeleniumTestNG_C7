package myproject.Day11;

import myproject.base.TestBase2;
import myproject.utilities.BrowserUtils;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C2_AlertPratice extends TestBase2 {

    @Test
    public void TC1(){
        /*
        Go to "http://the-internet.herokuapp.com/"
        click JavaScript Alerts
        Click for Js Prompt
        Enter "hello word" text
        Click okay
        Validate your text appearing on the page
                */
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("herokuapp"));
        DriverUtil.getDriver().findElement(By.linkText("JavaScript Alerts")).click();
        DriverUtil.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert =DriverUtil.getDriver().switchTo().alert();
        BrowserUtils.wait(2);
        alert.sendKeys("Hello word");
        BrowserUtils.wait(2);
        alert.accept();

        WebElement result = DriverUtil.getDriver().findElement(By.cssSelector("#result"));
        Assert.assertTrue(result.getText().contains("Hello word"),"validation has failed");
        System.out.println("validation has passed!!!");
    }
}
