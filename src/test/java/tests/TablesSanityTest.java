package tests;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.W3schoolsTablesPage;
import pages.base.BasePage;
import tests.base.BaseTestClass;

import java.io.IOException;

//TablesSanityTest is a Test Class
public class TablesSanityTest extends BaseTestClass {

    @Test(priority = 1, enabled = false)
    public void BrowseToTables() throws IOException {
        BasePage basePage = new BasePage(driver);

        try {
            //Brows to the URL_W3SCHOOLS_TABLES that is a property in the properties file
            driver.get(basePage.getEnvProperty("URL_W3SCHOOLS_TABLES"));

            //Create a W3schools Tables Page
            W3schoolsTablesPage w3schoolsTablesPage = new W3schoolsTablesPage(driver);

            //Fail the test in case the main headline of the page does not contain the correct text
            Assert.assertTrue(w3schoolsTablesPage.isTablesPage());
        }

        //Catching the exception and printing it - to control how error message is printed to the log
        //Then throwing the exception again to brake the test
        catch (Exception e) {
            System.out.println(basePage.getEnvProperty("TEST_EXCEPTION_MSG") + " \n" + e.getMessage());
            throw e;
        }

        //Catching the Assertion Error and printing it - to control how error message is printed to the log
        //Then throwing the Assertion Error again to fail the test
        catch (AssertionError e) {
            System.out.println(basePage.getEnvProperty("TEST_FAILED_MSG") + " \n" + e.getMessage());
            Assert.fail();
        }
    }

    @Test(priority = 2)
    public void SearchInTable() throws Exception {
        BasePage basePage = new BasePage(driver);
        try {
            //Brows to the URL_W3SCHOOLS_TABLES that is a property in the properties file
            driver.get(basePage.getEnvProperty("URL_W3SCHOOLS_TABLES"));

            //Create a W3schools Tables Page
            W3schoolsTablesPage w3schoolsTablesPage = new W3schoolsTablesPage(driver);

            //Fail the test in case the main headline of the page does not contain the correct text
            Assert.assertTrue(w3schoolsTablesPage.isTablesPage());

            test.log(Status.INFO, MarkupHelper.createLabel("In Tables Page", ExtentColor.BLUE));

            int searchColumn = 1;
            String searchText = "Alfreds Futterkiste";
            int returnColumnText = 1;
            String expectedText = "Alfreds Futterkiste";
            Assert.assertTrue(w3schoolsTablesPage.verifyTableCellText(w3schoolsTablesPage.getTable(driver), searchColumn, searchText, returnColumnText, expectedText));
            test.log(Status.INFO, MarkupHelper.createLabel("Test Data: searchColumn: " + searchColumn + ", searchText: " + searchText + ", returnColumnText " + returnColumnText + ", expectedText: " + expectedText, ExtentColor.BLUE));

            searchColumn = 1;
            searchText = "Alfreds Futterkiste";
            returnColumnText = 2;
            expectedText = "Maria Anders";
            Assert.assertTrue(w3schoolsTablesPage.verifyTableCellText(w3schoolsTablesPage.getTable(driver), searchColumn, searchText, returnColumnText, expectedText));
            test.log(Status.INFO, MarkupHelper.createLabel("Test Data: searchColumn: " + searchColumn + ", searchText: " + searchText + ", returnColumnText " + returnColumnText + ", expectedText: " + expectedText, ExtentColor.BLUE));

            searchColumn = 1;
            searchText = "Alfreds Futterkiste";
            returnColumnText = 3;
            expectedText = "Germany";
            Assert.assertTrue(w3schoolsTablesPage.verifyTableCellText(w3schoolsTablesPage.getTable(driver), searchColumn, searchText, returnColumnText, expectedText));
            test.log(Status.INFO, MarkupHelper.createLabel("Test Data: searchColumn: " + searchColumn + ", searchText: " + searchText + ", returnColumnText " + returnColumnText + ", expectedText: " + expectedText, ExtentColor.BLUE));

            //Example of fail tests
//            searchColumn = 1;
//            searchText = "Alfreds Futterkiste";
//            returnColumnText = 1;
//            expectedText = "Germany";
//            Assert.assertTrue(w3schoolsTablesPage.verifyTableCellText(w3schoolsTablesPage.getTable(driver), searchColumn, searchText, returnColumnText, expectedText));
//            test.log(Status.INFO, MarkupHelper.createLabel("Test Data: searchColumn: " + searchColumn + ", searchText: " + searchText + ", returnColumnText + " + returnColumnText + ", expectedText: " + expectedText, ExtentColor.BLUE));
        }

        //Catching the exception and printing it - to control how error message is printed to the log
        //Then throwing the exception again to brake the test
        catch (Exception e) {
            System.out.println(basePage.getEnvProperty("TEST_EXCEPTION_MSG") + " \n" + e.getMessage());
            throw e;
        }

        //Catching the Assertion Error and printing it - to control how error message is printed to the log
        //Then throwing the Assertion Error again to fail the test
        catch (AssertionError e) {
            System.out.println(basePage.getEnvProperty("TEST_FAILED_MSG") + " \n" + e.getMessage());
            Assert.fail();
        }
    }
}
