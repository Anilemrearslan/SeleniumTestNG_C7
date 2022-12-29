package myproject.Labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab01 {
    /*
    ##Task 1

    Go to https://www.etsy.com/
    Maximize window

    ##Task 2
    Go to https://www.amazon.com/
    get title and print out
     */

    public static void main(String[] args) {
        /*
        ##Task 1
        Go to https://www.etsy.com/
        Maximize window
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        ##Task 2
        Go to https://www.amazon.com/
        get title and print out
         */
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
}
