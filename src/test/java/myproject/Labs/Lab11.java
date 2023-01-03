package myproject.Labs;


import myproject.base.TestBase2;
import myproject.utilities.BrowserUtils;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Lab11 extends TestBase2 {

    @Test()
    public void TC1_Task1(){
        //Launch the web browser and open the site http://demo.guru99.com/test/delete_customer.php
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("DemoGuru99_Url2"));
        //Enter Any Customer id
        WebElement ID = DriverUtil.getDriver().findElement(By.xpath("//input[@name='cusid']"));
        ID.sendKeys("Lahmacun");
        //After entering the customer ID, Click on the “Submit” button.
        WebElement SubmitButton = DriverUtil.getDriver().findElement(By.xpath("//input[@name='submit']"));
        SubmitButton.click();
        //Reject/accept the alert.
        Alert alert = DriverUtil.getDriver().switchTo().alert();
        BrowserUtils.wait(4);
        alert.dismiss();
    }

    @Test
    public void TC2_Task2(){
        //go to http://the-internet.herokuapp.com/hovers
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("herokuapp_Url"));
        //move mouse to third image(you may use move to element method in actions)
        WebElement thirdImage = DriverUtil.getDriver().findElement(By.xpath("//div[@id='content']/div/div[3]/img"));
        Actions action = new Actions(DriverUtil.getDriver());
        action.moveToElement(thirdImage).perform();
        //verify text of image present on the screen
        WebElement TextOfImage = DriverUtil.getDriver().findElement(By.xpath("//*[@id='content']/div/div[3]/div/h5"));
        String Text = TextOfImage.getText();
        Assert.assertTrue(Text.contains("user3"),"Text not found. Verification has failed!");
        System.out.println("verification has passed!");

    }
}
