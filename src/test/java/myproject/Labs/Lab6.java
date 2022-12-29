package myproject.Labs;

import myproject.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab6 {
    //go to http://demo.guru99.com/test/newtours/register.php
    // click on country dropdown and select Barbados with Select Method
    //Use 3 different Select Method (visible text,index,value)
    //and switch to another countries as you wish
    WebDriver driver;

    @BeforeTest
    public void Setup(){

        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //go to http://demo.guru99.com/test/newtours/register.php
        driver.get("http://demo.guru99.com/test/newtours/register.php");

    }

    @Test

    public void TC1() throws InterruptedException {

        // click on country dropdown and select Barbados with Select Method
        WebElement DropDown= driver.findElement(By.xpath("//select[@name='country']"));
        DropDown.click();

        //Use 3 different Select Method (visible text,index,value)
        //and switch to another countries as you wish
        Select dropdown = new Select(DropDown);
        //1.country
        dropdown.selectByVisibleText("TURKEY");
        Thread.sleep(2000);
        //2.country
        dropdown.selectByValue("ARGENTINA");
        Thread.sleep(2000);
        //3.country
        dropdown.selectByIndex(19);//Barbados

    }


    @AfterMethod
    public void Closing(){
        driver.quit();
    }

}

