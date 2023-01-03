package myproject.Labs;

import myproject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lab09 extends TestBase {
    /*
    website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
Test Scenario:
* 		Go to the above URL.
* 		Get the current window’s handle and write to the console window. It must be the first window handle.
* 		Locate the “Visit W3Schools.com!” link and click it.
* 		Get all window handles and hold them in a list.
* 		Write to total window handle number to the console. It must be 2.
* 		Switch t the second window.
* 		Get the current window’s handle and write to the console window. It must be a second window handle.
* 		Check the upper left side logo in the second window.
* 		Go back (Switch) to the first window.
* 		Get the current window’s handle and write to the console window. It must be the first window handle.
* 		Check the See Run Button Text. It must contain “Run >” text.

     */

    @Test
    public void TC1(){
        //website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
        //Go to the above URL.
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        //Get the current window’s handle and write to the console window. It must be the first window handle.
        String FirstWindowHandle=driver.getWindowHandle();
        System.out.println(FirstWindowHandle);

        //Locate the “Visit W3Schools.com!” link and click it.
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.linkText("Visit W3Schools.com!")).click();

        //Get all window handles and hold them in a list.
        Set<String> Windows= driver.getWindowHandles();

        List<String> WindowsList = new ArrayList<>();
        for (String EachWindow:Windows){
            driver.switchTo().window(EachWindow);
            WindowsList.add(EachWindow);
        }
        //Write to total window handle number to the console. It must be 2.
        System.out.println(Windows.size()+" times windows handled");

        //Switch t the second window.
        driver.switchTo().window(WindowsList.get(1));

        //Get the current window’s handle and write to the console window. It must be a second window handle.
        String currentWindowHandle=driver.getWindowHandle();
        Assert.assertEquals(currentWindowHandle,WindowsList.get(1),"Windows Handle is failed");
        System.out.println("Second Window handle has passed");

        //Check the upper left side logo in the second window.
        WebElement UpperLeftLogo = driver.findElement(By.cssSelector(".fa.fa-logo"));
        UpperLeftLogo.click();

        //Go back (Switch) to the first window.
        driver.switchTo().window(WindowsList.get(0));

        //Get the current window’s handle and write to the console window. It must be the first window handle.
        currentWindowHandle=driver.getWindowHandle();
        Assert.assertEquals(currentWindowHandle,WindowsList.get(0),"Windows Handle is failed");
        System.out.println("First window handle's passed");

        //Check the See Run Button Text. It must contain “Run >” text.
        WebElement RunButton = driver.findElement(By.id("runbtn"));
        System.out.println(RunButton.getText());
    }
}
