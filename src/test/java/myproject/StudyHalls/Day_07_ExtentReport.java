package myproject.StudyHalls;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class Day_07_ExtentReport {

    public static ExtentReports generateExtentReport(){

        ExtentReports extentReports = new ExtentReports();
        File path = new File("C:\\Users\\anile\\IdeaProjects\\SeleniumTestNG_C7\\ExtentReports/"+"My Report"+".html");
        ExtentSparkReporter spark = new ExtentSparkReporter(path);
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("RenasTech");
        spark.config().setDocumentTitle("Automation");
        spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Aplication URL", "https://www.ebay.com/");
        extentReports.setSystemInfo("Browser Name URL", "Chrome");

        return extentReports;

    }
}
