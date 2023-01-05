package myproject.POMPages;

import myproject.utilities.DriverUtil;
import org.openqa.selenium.support.PageFactory;

public class SmartBearWebOrdersPage {

    public SmartBearWebOrdersPage(){
        PageFactory.initElements(DriverUtil.getDriver(),this);
    }
}
