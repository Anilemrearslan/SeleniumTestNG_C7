package myproject.Day07;

import com.github.javafaker.Faker;
import myproject.utilities.SmartBearUtils;
import myproject.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class C3_SmartBearWithJavaFaker {
    //1- Open a chrome browser
    //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3- Login
    //4. Click on Order
    //5. Select familyAlbum from product, set quantity to 5
    //6. Click to "Calculate" button
    //7. Fill address Info with JavaFaker
    //8. Click on "visa" radio button
    //9. Generate card number using JavaFaker
    //10Enter expiration date
    //11. Click on "Process"
    //12.Verify success message "New order has been successfully

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        //1- Open a chrome browser
        //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3- Login

        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.loginForSmartbearUtil(driver);
    }

    @Test
    public void TC1_JavaFakerPractice(){

        //4. Click on Order
        WebElement OrderLink = driver.findElement(By.linkText("Order"));
        OrderLink.click();
        //5. Select familyAlbum from product, set quantity to 5
        WebElement DropDownBox=driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select dropdown = new Select(DropDownBox);
        dropdown.selectByVisibleText("FamilyAlbum");

        WebElement Quantity= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        Quantity.sendKeys(Keys.BACK_SPACE);
        Quantity.sendKeys("5");

        //6. Click to "Calculate" button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //7. Fill address Info with JavaFaker
        Faker faker = new Faker();
        WebElement CustomerName= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        CustomerName.sendKeys(faker.name().fullName());
        WebElement StreetName= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        StreetName.sendKeys(faker.address().streetAddress());

        WebElement City = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        City.sendKeys(faker.address().city());

        WebElement State=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        State.sendKeys(faker.address().state());

        WebElement Zip=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        Zip.sendKeys(faker.address().zipCode().replaceAll("-",""));



        //8. Click on "visa" radio button
        driver.findElement(By.xpath("//input[@value='Visa']")).click();

        //9. Generate card number using JavaFaker
        WebElement CardNumber = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_fmwOrder_TextBox6']"));
        CardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        //10Enter expiration date
        WebElement ExpDate =driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_fmwOrder_TextBox1']"));
        ExpDate.sendKeys("12/23");
        //11. Click on "Process"
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
        //12.Verify success message "New order has been successfully
        WebElement SuccessMessage = driver.findElement(By.tagName("strong"));
        Assert.assertEquals(SuccessMessage.getText(),"New order has been successfully added.");
        System.out.println("\"New order has been successfully added.\"");
    }
}
