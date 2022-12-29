package myproject.Day08;

import myproject.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C3_iFrame {
    //1- Open a chrome browser
    //2- Go to:http://the-internet.herokuapp.com/iframe
    //3- Switching by id or name attribute value.

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        //1- Open a chrome browser
        driver= WebDriverUtil.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2- Go to:http://the-internet.herokuapp.com/iframe
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void TC1(){
        //3- Switching by id or name attribute value.
        //if there is an iFrame first Switch to iFrame
        // there is 3 ways to switch iframe: id/name, index, webElement
        driver.switchTo().frame(0);
        WebElement TextBox = driver.findElement(By.id("tinymce"));
        TextBox.clear();
        TextBox.sendKeys("hello Anil");
        //in order to return main HTML code, use this:
        driver.switchTo().defaultContent();
        //in order to return previous frame use driver.switchTo().parentFrame();

    }
}
