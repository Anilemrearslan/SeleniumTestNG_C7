package myproject.Day11;

import myproject.base.TestBase2;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C1_DriverUtilPractice extends TestBase2 {
    //go to google
    //search for 'best city to celebrate new year'
    //verify that title contains searchItem
    @Test
    public void TC1(){
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("google_url"));
        WebElement SearchBox=DriverUtil.getDriver().findElement(By.name("q"));
        SearchBox.sendKeys(PropertiesReadingUtil.getProperties("SearchItem"));
        WebElement SearchButton = DriverUtil.getDriver().findElement(By.name("btnK"));
        SearchButton.click();
        String searchItem = PropertiesReadingUtil.getProperties("SearchItem");
        Assert.assertTrue(DriverUtil.getDriver().getTitle().contains(searchItem));

    }
}
