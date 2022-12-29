package myproject.Labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab04 {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //2. Go to https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");
        //3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
        //4. Click to checkbox3
        //5. Verify checkbox3 is selected
    }
}
