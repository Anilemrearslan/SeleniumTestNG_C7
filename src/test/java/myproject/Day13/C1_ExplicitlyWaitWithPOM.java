package myproject.Day13;

import myproject.POMPages.SeleniumPractiseHomePage;
import myproject.base.TestBase2;
import myproject.utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C1_ExplicitlyWaitWithPOM extends TestBase2 {
    @Test
    public void TC1_explicitlyWait(){

        DriverUtil.getDriver().get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        SeleniumPractiseHomePage seleniumPractiseHomePage = new SeleniumPractiseHomePage();
        seleniumPractiseHomePage.clickTimerButton();
        seleniumPractiseHomePage.getDefaultText();
        // verfy "webDriver" text present
        System.out.println(seleniumPractiseHomePage.getWebDriverText().getText());
        String actualtext = seleniumPractiseHomePage.getWebDriverText().getText();
        Assert.assertEquals(actualtext,"WebDriver","WebDriver is not present verification has failed!!! ");
        seleniumPractiseHomePage.getDefaultText();
    }
}
