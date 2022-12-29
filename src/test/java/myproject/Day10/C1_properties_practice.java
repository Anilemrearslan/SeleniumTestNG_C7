package myproject.Day10;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class C1_properties_practice {

    @Test
    public void TC1_system_properties(){
        //Java has some properties that we can use to get system info
        System.out.println(System.getProperty("os.name"));
    }

    @Test
    public void TC2_configuration_properties(){
        Properties properties = new Properties();

        //this is a path for configuration.properties file
        String pathForPropertiesFile = "configuration.properties";


        try {
            //tell compiler to open file
            FileInputStream fileinputStream = new FileInputStream(pathForPropertiesFile);
            properties.load(fileinputStream);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("SmartBearUrl"));
        System.out.println(properties.getProperty("SmartBear_userName"));
        System.out.println(properties.getProperty("SmartBear_password"));

    }
}
