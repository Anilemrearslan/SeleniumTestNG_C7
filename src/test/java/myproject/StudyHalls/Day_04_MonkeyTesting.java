package myproject.StudyHalls;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Day_04_MonkeyTesting {

    //Monkey Testing: you as a user click the functionalities randomly
    // you do not fallow the steps. you try to break the app by clicking random links

    @Test
    public void TC1_MonkeyTesting(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/ca/?ref=lgo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> LinkList = driver.findElements(By.cssSelector("ul[data-ui='top-nav-category-list'] li a"));

        int headrCount  = LinkList.size();
        System.out.println(headrCount);

        for (int i = 0; i < headrCount; i++) {
            //Math for random index
            int randomIndex =(int) Math.floor(Math.random()*headrCount);
            System.out.println(randomIndex);
            WebElement element = LinkList.get(randomIndex);
            System.out.println(element.getText());
            element.click();
            driver.navigate().back();
            //element.click();
        /*If we use element.click(); again, selenium will not recognise and you'll get
        * StateElementReferenceException the reason for that you can not use same element
        * when you navigate back Because it's counted as outdated.
        * You need to declare that element again to avoid exception.
        * */
            LinkList = driver.findElements(By.cssSelector("ul[data-ui='top-nav-category-list'] li a"));

        }

    }
}
