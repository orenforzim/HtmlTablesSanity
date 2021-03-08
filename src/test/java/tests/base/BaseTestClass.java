package tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.MethodsManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

//BaseTestClass is the base to all the other Test Class its not a Test Class
@SuppressWarnings("deprecation")
public class BaseTestClass {

    //The ExtentReports is Static so a new instant will not be created with every "AfterMethod"
    protected static ExtentReports extent;
    protected WebDriver driver;
    //helps to generate the logs in test report.
    protected ExtentTest test;
    //builds a new report using the html template
    ExtentHtmlReporter htmlReporter;

    @Parameters({"OS", "browser"})
    @BeforeTest
    public void startReport(String OS, String browser) {
        //Create a date and time String that will be added to to the Html Report as suffix to the file name
        long timeInMs = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm");
        String dateStr = dateFormat.format(new Date(timeInMs));

        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter("test-output/testReport_" + dateStr + ".html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);

        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    //Every Before and After method is printing the name of the current Class or Test and state if its Initiating or Terminating it
    //This before class will initiate the properties from external file, this is a prerequisite for all the tests
    @BeforeClass
    protected void setUpClass() {
        //Print to the log the name of the class that started
        String className = this.getClass().getName();
        System.out.println("Initiate Class: " + className);
    }

    @AfterClass
    protected void tearDownClass() {
        //Print to the log the name of the class that ended
        String className = this.getClass().getName();
        System.out.println("Terminate Class: " + className);
    }

    //Before each test - This function will initiate the browser
    @BeforeMethod
    protected void setUp(Method method) {
        //Print to the log the name of the test that started
        String methodName = method.getName();
        String className = this.getClass().getName();

        String description = "This test is part of the ZIM assignment";

        //Making the test names nicer in the report
        String testHeadline = (className + " - " + methodName).replaceAll("(.)([A-Z])", "$1 $2");
        test = extent.createTest(testHeadline.substring(6), description);
        System.out.println("Initiate Test: " + methodName);

        //Initiate the WebDriver
        driver = MethodsManager.choseChromeDriver();
    }

    //After each test - This function will close the browser
    @AfterMethod
    protected void tearDown(Method method, ITestResult result) throws IOException {

        //Add the test results to the html report
        //When test fail
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            //Add information to the html results report
            test.fail(result.getThrowable());
            //Add image to the html results report
            test.fail("Click to see image: ", MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());

            //When test pass
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

            //When test skip
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
        }

        //Update test information to HTML reporter
        extent.flush();
        //Quit the WebDriver
        driver.quit();

        //Print to the log the name of the test that ended
        String methodName = method.getName();
        System.out.println("Terminate Test: " + methodName);
    }
}
