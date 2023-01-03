package myproject.base;

import myproject.utilities.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase2 {

    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        DriverUtil.getDriver().manage().window().maximize();
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void closing(){
        // DriverUtil.closeDriver();
    }
}
