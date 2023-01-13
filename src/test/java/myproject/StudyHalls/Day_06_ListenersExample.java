package myproject.StudyHalls;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Day_06_ListenersTestNG.class)
public class Day_06_ListenersExample {



    public WebDriver driver;
    String ExpectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
    @BeforeMethod
    public void lunch(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void test1() {
        System.out.println("I am inside Test 1");
        String actualTitle= driver.getTitle();
        Assert.assertEquals(ExpectedTitle,actualTitle);
    }

    @Test
    public void test2() {
        System.out.println("I am inside Test 2");
        throw new SkipException("TestSkipped");
    }

    @Test
    public void test3() {
        System.out.println("I am inside Test 3");
        String Text = driver.findElement(By.xpath("//a[contains(text(),'Score these trending kicks')]")).getText();
        Assert.assertEquals(Text,"Failed");
    }
}
