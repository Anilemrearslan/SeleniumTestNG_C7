package myproject.Labs;



import myproject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lab10 extends TestBase {
    /*
    Prerequisites= Create username and password for guru99
    //navigate to http://demo.guru99.com/V4/
    //Login to Guru99 with username and password
    //Use JavaScript executer to click on login
    //Verify that you login to page
     */




    @Test
    public void TC1(){
        //navigate to http://demo.guru99.com/V4/
        driver.get("https://demo.guru99.com/V4/");

        //Login to Guru99 with username and password
        Properties properties = new Properties();
        String Lab10Properties = "configuration.Properties";

        try{
            FileInputStream fileInputStream = new FileInputStream(Lab10Properties);
            properties.load(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }

        WebElement UserID=driver.findElement(By.xpath("//input[@onblur='validateuserid();']"));
        UserID.sendKeys(properties.getProperty("DemoGuru99_UserID"));
        WebElement PassWord = driver.findElement(By.xpath("//input[@onblur='validatepassword();']"));
        PassWord.sendKeys(properties.getProperty("DemoGuru99_password"));

        ////Use JavaScript executer to click on login
        WebElement LoginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",LoginButton);

        //Verify that you login to page
        Assert.assertTrue(driver.getTitle().contains("Guru99 Bank"),"Login verification has failed");
        System.out.println("Login verification has passed");

    }

}
