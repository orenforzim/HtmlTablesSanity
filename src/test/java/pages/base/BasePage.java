package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//BasePage is the base to all the other Pages its not a Page Class
public class BasePage {

    static protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;
    protected Properties locators;

    //Constructor
    public BasePage(WebDriver driver) throws IOException {
        this.driver = driver;

        //Set the default WebDriverWait for all the pages
        this.wait = new WebDriverWait(this.driver, 30);

        //Create the properties variable
        properties = new Properties();
        //Get data from file to the properties variable
        FileInputStream input = new FileInputStream("src/test/java/utilities/resources/env.properties");
        //Load the data into the properties file
        properties.load(input);

        //Create the properties variable for the locators
        locators = new Properties();
        //Get data from file to the locators properties variable
        input = new FileInputStream("src/test/java/utilities/resources/locators.properties");
        //Load the data into the locators properties file
        locators.load(input);
    }

    public String getEnvProperty(String EnvPropertyName) {
        return properties.getProperty(EnvPropertyName);
    }
}
