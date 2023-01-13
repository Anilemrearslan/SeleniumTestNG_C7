package myproject.StudyHalls;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

//Navigate to "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
//Click on the "Try it" button
//Enter Your name on the Alert Box and Accept alert
//Verify that your name shown on the page
//Click on the 'home sign' (it is on the left side of page)
//Switch to second window tab
//Click on the "log in" button
//Enter your credentials
//Enter the show password button
//Switch to first tab
public class Day_05_LAb12Solution {

    protected WebDriver driver;
    Set<String> tabs;
    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        System.out.println("Test is completed");
        //driver.quit();
    }

    @Test(priority = 1)
    public void TC1_goURL(){
        driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
    }
    @Test(priority = 2, dependsOnMethods = {"TC1_goURL"})
    public void TC2_ClickTry(){
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        String Text = "anil";
        alert.sendKeys(Text);
        alert.accept();
        WebElement textInput = driver.findElement(By.id("demo"));
        Assert.assertTrue(textInput.getText().contains(Text),"verification has failed");
        System.out.println("verification has failed");
    }
    @Test(priority = 3, dependsOnMethods = "TC2_ClickTry")
    public void TC3_HomePage(){
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tryhome")).click();
    }
    @Test(priority = 4, dependsOnMethods = "TC3_HomePage")
    public void TC4_LogINButton(){
        //w3loginbtn->id
        tabs = driver.getWindowHandles();
        for (String EachTab:tabs){
            driver.switchTo().window(EachTab);
        }
        System.out.println("current title of the page "+driver.getTitle());
        driver.findElement(By.id("w3loginbtn")).click();
    }

    @Test(priority = 5, dependsOnMethods ="TC4_LogINButton")
    public void TC5_SwitchToFirstTab(){
        driver.findElement(By.name("email")).sendKeys("anilemre167@gmail.com");

    }
}
