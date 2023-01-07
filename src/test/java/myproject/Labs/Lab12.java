package myproject.Labs;

import myproject.base.TestBase2;
import myproject.utilities.BrowserUtils;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab12 extends TestBase2 {
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
        //Click on the 'home sign' (it is on the left side of page)
        DriverUtil.getDriver().switchTo().defaultContent();
        DriverUtil.getDriver().findElement(By.xpath("//a[@id='tryhome']")).click();
        //Switch to second window tab
        String FirstTab = DriverUtil.getDriver().getWindowHandle();
        Set<String>Tabs = DriverUtil.getDriver().getWindowHandles();
        for(String NewTab:Tabs) {
            DriverUtil.getDriver().switchTo().window(NewTab);
        }
        //Click on the "log in" button
        DriverUtil.getDriver().findElement(By.id("w3loginbtn")).click();
        //Enter your credentials
        WebElement eMailBox = DriverUtil.getDriver().findElement(By.xpath("//input[@name='email']"));
        eMailBox.sendKeys(PropertiesReadingUtil.getProperties("MyEmail"));
        WebElement passWordBox = DriverUtil.getDriver().findElement(By.xpath("//input[@name='current-password']"));
        passWordBox.sendKeys(PropertiesReadingUtil.getProperties("MyPassWord"));
        //Enter the show password button
        WebElement ShowButton = DriverUtil.getDriver().findElement(By.xpath("//span[@class='PasswordInput_show_pwd_btn__Ncc9S']"));
        ShowButton.click();
        //Switch to first tab
        DriverUtil.getDriver().switchTo().window(FirstTab);
    }
}
