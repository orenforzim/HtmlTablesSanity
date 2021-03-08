package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodsManager {

    private static WebDriver driver;

    //Create the setting to run test on chrome browser
    public static WebDriver choseChromeDriver() {
        //Driver exe file location
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //Less unneeded messages in the log
        System.setProperty("webdriver.chrome.silentOutput", "true");
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);

        //Create the driver
        driver = new ChromeDriver();

        //Set implicit wait of 30 sec
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Set windows size to max
        driver.manage().window().maximize();

        //Return Driver
        return driver;
    }

    //This function wait for the element with text to become visible
    //The function also print a message with the display text correct/missing to the console log
    //In case of mistake in the text, the wrong text is also printed to the console
    public static boolean isTextCorrect(By ByElementWithText, String textToTest, String correctMsg, String errorMsg) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement temWebElement = driver.findElement(ByElementWithText);
        wait.until(ExpectedConditions.visibilityOf(temWebElement));

        if (temWebElement.getText().contains(textToTest)) {
            System.out.println(correctMsg);
            return true;
        } else {
            System.out.println(errorMsg);
            System.out.println("Visible text is: " + temWebElement.getText());
            return false;
        }
    }
}
