package myproject.Labs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab02 {

    public static void main(String[] args) throws InterruptedException {
        //TC #1: Facebook title verification
        //Task - 1
        //Open Chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        //Verify title: Expected: "Facebook - Log In or Sign Up"
        String ExpectedTitle = "Facebook - Log In or Sign Up";
        String ActualTitle = driver.getTitle();
        System.out.println(ActualTitle);
        if (ActualTitle.equals(ExpectedTitle)){
            System.out.println("your expected title and actual title are matching. Your Test has passed");
        }else {
            System.out.println("your expected title and actual title are NOT matching. Your Test has failed");
        }
        Thread.sleep(2000);
        driver.quit();

        //Task - 2
        //Open Chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver2=new ChromeDriver();
        //Go to google
        driver2.get("https://www.google.com");
        //Navigate back
        driver2.navigate().back();
        //Navigate forward
        driver2.navigate().forward();
        //Navigate to https://www.amazon.com
        driver2.navigate().to("https://www.amazon.com");
        //Verify title contains : Smile
        boolean check= driver2.getTitle().contains("Smile");
        if (check){
            System.out.println("your title contains \"Smile\". Your Test has passed ");
        }else {
            System.out.println("your title doesn't contains \"Smile\". Your Test has failed ");
        }
        Thread.sleep(2000);
        driver.quit();


        //Second Task:
        // Go to https://www.etsy.com/
        WebDriverManager.chromedriver().setup();
        WebDriver driver3=new ChromeDriver();

        // Maximize window
        driver3.manage().window().maximize();

        // Verify title doesnt contains "Smile"
        String ActualT=driver3.getTitle();
        if (!ActualT.contains("Smile")){
            System.out.println("Title doesn't contains \"Smile\". Verification has passed.");
        }else {
            System.out.println("Title does contains \"Smile\". Verification has failed.");
        }

        // Verify Current Url
        System.out.println("URL is = "+driver3.getCurrentUrl());

        // Go to https://www.amazon.com/
        driver3.navigate().to("https://www.amazon.com");

        // Verify title
        System.out.println("Title is = "+driver3.getTitle());
        // Verify Current Url
        System.out.println("URL is = "+driver3.getCurrentUrl());

        // Navigate Back
        driver3.navigate().back();
        // Refresh
        driver3.navigate().refresh();
        // Quit browser
        driver3.quit();


    }
}
