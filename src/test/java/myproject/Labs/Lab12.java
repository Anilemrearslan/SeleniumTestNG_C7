package myproject.Labs;

import myproject.base.TestBase2;
import myproject.utilities.BrowserUtils;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab12 extends TestBase2 {




    //Click on the 'home sign' (it is on the left side of page)
    //Switch to second window tab
    //Click on the "log in" button
    //Enter your credentials
    //Enter the show password button
    //Switch to first tab

    @Test
    public void TC1(){
        //Navigate to "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("w3schools_Url"));
        //Click on the "Try it" button
        DriverUtil.getDriver().switchTo().frame("iframeResult");
        WebElement TryItButton = DriverUtil.getDriver().findElement(By.xpath("//button[@onclick='myFunction()']"));
        TryItButton.click();
        //Enter Your name on the Alert Box and Accept alert
        Alert alert = DriverUtil.getDriver().switchTo().alert();
        alert.sendKeys("Anil");

        alert.accept();
        //Verify that your name shown on the page
        WebElement Text = DriverUtil.getDriver().findElement(By.cssSelector("#demo"));
        Assert.assertTrue(Text.getText().contains("Anil"),"verification has failed!");
        System.out.println("verification has passed!");
    }
}
