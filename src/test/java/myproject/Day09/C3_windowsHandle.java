package myproject.Day09;

import myproject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C3_windowsHandle extends TestBase {
    @Test
    public void TC1_multiwindows(){
        driver.get("https://renas-practice.herokuapp.com/selenium/elements");
        System.out.println("current title is: "+driver.getTitle());
        driver.findElement(By.id("WindowsII")).click();
        WebElement openWindowButton = driver.findElement(By.id("open-window"));
        openWindowButton.click();

        Set<String> allWındows = driver.getWindowHandles(); // store all windows

        List<String> windowsList = new ArrayList<>();

        for (String newWindow:allWındows){
            driver.switchTo().window(newWindow);
            windowsList.add(newWindow);
            System.out.println("current title is: "+driver.getTitle());
        }

        //another method to switch windows
        driver.switchTo().window(windowsList.get(0));
        System.out.println("After switching current title: "+driver.getTitle());

    }
}
