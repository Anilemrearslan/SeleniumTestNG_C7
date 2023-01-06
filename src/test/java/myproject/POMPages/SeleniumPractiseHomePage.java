package myproject.POMPages;

import myproject.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumPractiseHomePage extends BasePage{
    @FindBy(css = "button[onclick='timedText()']")
    public WebElement timerButton;
    @FindBy(id = "demo")
    public WebElement defaultText; //Click on "Try it". I will display Automation tools after some interval
    @FindBy(xpath = "//p[.='WebDriver']")
    public WebElement WebDriverText;

    public void getDefaultText(){
        System.out.println("default text = "+defaultText.getText());
    }
    public WebElement getWebDriverText(){
        driverWait.until(ExpectedConditions.visibilityOf(WebDriverText));
        return WebDriverText;
    }

    public void clickTimerButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(timerButton)).click();
    }
}

