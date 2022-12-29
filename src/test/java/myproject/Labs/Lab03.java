package myproject.Labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab03 {
    public static void main(String[] args) throws InterruptedException {


        //TASK: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Write “apple” in search box
        WebElement GoogleSearchBox = driver.findElement(By.name("q"));
        GoogleSearchBox.sendKeys("apple");
        Thread.sleep(2000);

        //4- Click google search button
        WebElement GoogleSearchButton = driver.findElement(By.xpath("//input[@role='button']"));
        GoogleSearchButton.click();

        //5- Verify title:
        //Expected: Title should start with "apple" word
        String ActualTitle = driver.getTitle();
        if (ActualTitle.startsWith("apple")){
            System.out.println("Title verification has passed");
        }else {
            System.out.println("Title verification has failed");
        }

        //6-navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        //7-write cherry in search box
        GoogleSearchBox.sendKeys("cherry");
        Thread.sleep(2000);
        GoogleSearchButton.click();

        //8-verify title contains cherry.
        if (driver.getTitle().contains("cherry")){
            System.out.println("Title verification has passed");
        }else {
            System.out.println("Title verification has failed");
        }
        driver.quit();




        //TASK2: Google Feeling lucky button
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();
        //2- Go to: https://google.com
        driver2.get("https://google.com");

        //3- Write "apple" in search box
        driver2.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(2000);

        //click i am feeling lucky button
        driver2.findElement(By.name("btnI")).click();

        //Verify title contains Apple
        if (driver2.getTitle().equalsIgnoreCase("apple")){
            System.out.println("Title contains apple. Verification has passed");
        }else {
            System.out.println("Title doesn't contains apple. Verification has failed");
        }
        Thread.sleep(2000);

        //go to https://opensource-demo.orangehrmlive.com/
        driver2.navigate().to("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(2000);

        //locate user name and send user name, (username=Admin)
        driver2.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(2000);

        //locate user password and send password (password=admin123)
        driver2.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(2000);

        //click on the login button
        driver2.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
