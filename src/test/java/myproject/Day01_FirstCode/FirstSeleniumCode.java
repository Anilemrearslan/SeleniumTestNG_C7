package myproject.Day01_FirstCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumCode {

    public static void main(String[] args) {
        System.out.println("Hello world");
        //set up driver
        WebDriverManager.chromedriver().setup();

        // create an instance of the driver

        WebDriver driver = new ChromeDriver();

        //navigate to Chrome browser

        driver.get("https://www.google.com/");

    }
}
