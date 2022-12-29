package myproject.Labs;

import com.github.javafaker.Faker;
import myproject.utilities.BrowserUtils;
import myproject.utilities.WebDriverUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab08 {

//1) Launch the web browser and open the site http://demo.guru99.com/test/delete_customer.php
//Step 2) Enter Any Customer id.
//Step 3) After entering the customer ID, Click on the “Submit” button.
//Step 4) Reject/accept the alert.

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1) Launch the web browser and open the site http://demo.guru99.com/test/delete_customer.php
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @Test
    public void TC1_CustomerID(){
        //Step 2) Enter Any Customer id.
        WebElement CustomerId = driver.findElement(By.name("cusid"));
        Faker faker = new Faker();
        CustomerId.sendKeys(faker.idNumber().invalid());
        //Step 3) After entering the customer ID, Click on the “Submit” button.
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        //Step 4) Reject/accept the alert.
        Alert alert = driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.accept();
        BrowserUtils.wait(2);
        alert.dismiss();
    }

    @AfterMethod
    public void Closing(){
        driver.quit();
    }
}
