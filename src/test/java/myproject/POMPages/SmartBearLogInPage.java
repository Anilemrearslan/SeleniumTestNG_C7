package myproject.POMPages;

import myproject.utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLogInPage {

    public SmartBearLogInPage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }

    //@FindBy() annotation to locate web elements
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement UserNameBox;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_password']")
    public WebElement UserPasswordBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement LogInButton;

    @FindBy(id = "ctl00_MainContent_status")
    private WebElement statusMessage;

    //create Methods related WebElements
    public void LoginForSmartBear(String username, String password){
        UserNameBox.sendKeys(username);
        UserPasswordBox.sendKeys(password);
        LogInButton.click();
    }

    public String getStatusMessage(){
        return statusMessage.getText();
    }
}
