package myproject.Day11;

import myproject.base.TestBase2;
import myproject.utilities.BrowserUtils;
import myproject.utilities.DriverUtil;
import myproject.utilities.PropertiesReadingUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C3_Actions extends TestBase2 {
    //go to http://demo.guru99.com/test/simple_context_menu.html
    //double click to double click button
    //then accept the alert that pops up
    Actions actions;
    @Test
    public void TC1(){
        //go to http://demo.guru99.com/test/simple_context_menu.html
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("DemoGuru99_Url"));
        //double click to double click button
        WebElement DoubleClickButton = DriverUtil.getDriver().findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        actions = new Actions(DriverUtil.getDriver());
        actions.doubleClick(DoubleClickButton).perform();
        BrowserUtils.wait(2);
        //then accept the alert that pops up
        Alert alert = DriverUtil.getDriver().switchTo().alert();
        alert.accept();
    }
    @Test
    public void TC2_RightClick(){
        //go to http://demo.guru99.com/test/simple_context_menu.html
        //right click to right click button
        //then click on edit button
        //then accept the alert that pops up

        //go to http://demo.guru99.com/test/simple_context_menu.html
        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("DemoGuru99_Url"));
        //right click to right click button
        WebElement RightClickButton = DriverUtil.getDriver().findElement(By.xpath("//span[.='right click me']"));
        actions = new Actions(DriverUtil.getDriver());
        actions.contextClick(RightClickButton).perform();
        BrowserUtils.wait(2);
        WebElement edit = DriverUtil.getDriver().findElement(By.xpath("//span[.='Edit']"));
        edit.click();
        BrowserUtils.wait(2);
        Alert alert = DriverUtil.getDriver().switchTo().alert();
        alert.accept();
    }

    @Test
    public void TC3_DragDrop(){
        DriverUtil.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
        //first find where drag from, in this case it is bank
        WebElement dragFrom = DriverUtil.getDriver().findElement(By.id("credit2"));
        //then find where to drop
        WebElement dropTo = DriverUtil.getDriver().findElement(By.id("bank"));
        //use action to drag and drop
        actions = new Actions(DriverUtil.getDriver());
        actions.dragAndDrop(dragFrom,dropTo).perform();

        //2 things need to be done:
        //first specify location of drag,
        //second specify location of drop

        WebElement dragFrom2 = DriverUtil.getDriver().findElement(By.id("fourth"));
        WebElement dropTo2 = DriverUtil.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(dragFrom2,dropTo2).perform();

    }
}
