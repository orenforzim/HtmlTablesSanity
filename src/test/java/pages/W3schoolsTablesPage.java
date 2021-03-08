package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import utilities.MethodsManager;

import java.io.IOException;

//W3schoolsTablesPage is a BasePage
public class W3schoolsTablesPage extends BasePage {

    //Locators of the tables page headline
    private final By ByTablesHeadline = By.cssSelector(locators.getProperty("TABLES_HEADLINE_CSS"));
    private final By ByExampleTable = By.xpath(locators.getProperty("TABLES_EXAMPLE_XPATH"));

    //Locators by Company
    private final By ByFirstCompany = By.xpath(locators.getProperty("TABLES_COMPANY_FIRST_XPATH"));
    private final By BySecondCompany = By.xpath(locators.getProperty("TABLES_COMPANY_SECOND_XPATH"));
    private final By ByThirdCompany = By.xpath(locators.getProperty("TABLES_COMPANY_THIRD_XPATH"));
    private final By ByFourthCompany = By.xpath(locators.getProperty("TABLES_COMPANY_FOURTH_XPATH"));
    private final By byFifthCompany = By.xpath(locators.getProperty("TABLES_COMPANY_FIFTH_XPATH"));
    private final By BySixthCompany = By.xpath(locators.getProperty("TABLES_COMPANY_SIXTH_XPATH"));

    //Locators by Contact
    private final By ByFirstContact = By.xpath(locators.getProperty("TABLES_CONTACT_FIRST_XPATH"));
    private final By BySecondContact = By.xpath(locators.getProperty("TABLES_CONTACT_SECOND_XPATH"));
    private final By ByThirdContact = By.xpath(locators.getProperty("TABLES_CONTACT_THIRD_XPATH"));
    private final By ByFourthContact = By.xpath(locators.getProperty("TABLES_CONTACT_FOURTH_XPATH"));
    private final By byFifthContact = By.xpath(locators.getProperty("TABLES_CONTACT_FIFTH_XPATH"));
    private final By BySixthContact = By.xpath(locators.getProperty("TABLES_CONTACT_SIXTH_XPATH"));

    //Locators by Country
    private final By ByFirstCountry = By.xpath(locators.getProperty("TABLES_COUNTRY_FIRST_XPATH"));
    private final By BySecondCountry = By.xpath(locators.getProperty("TABLES_COUNTRY_SECOND_XPATH"));
    private final By ByThirdCountry = By.xpath(locators.getProperty("TABLES_COUNTRY_THIRD_XPATH"));
    private final By ByFourthCountry = By.xpath(locators.getProperty("TABLES_COUNTRY_FOURTH_XPATH"));
    private final By byFifthCountry = By.xpath(locators.getProperty("TABLES_COUNTRY_FIFTH_XPATH"));
    private final By BySixthCountry = By.xpath(locators.getProperty("TABLES_COUNTRY_SIXTH_XPATH"));

    //Constructor
    public W3schoolsTablesPage(WebDriver driver) throws IOException {
        super(driver);
    }

    //Calling a function that return true, if text is correct on Tables page headline, or print the wrong text.
    public boolean isTablesPage() {
        return MethodsManager.isTextCorrect(ByTablesHeadline, properties.getProperty("TABLES_MAIN_TITLE"),
                properties.getProperty("TABLES_MAIN_TITLE_CORRECT_MSG"),
                properties.getProperty("TABLES_MAIN_TITLE_WRONG_MSG"));
    }

    //Return the table in this page since other functions need to get the table element by the SRS
    public WebElement getTable(WebDriver driver) {
        return driver.findElement(ByExampleTable);
    }


    //הפונקציות אמורות לקבל את אלמנט הטבלה, אינדקס או שם עמודה לחפש ערך, הערך לחיפוש, אינדקס או שם העמודה ממנה יוחזר ערך. למשל: הפונקציה תקבל שם חברה ותחזיר את שם המדינה
    //פונקציית verifyTableCellText צריכה להשתמש ב getTableCellTextByXpath ולדווח הצלחה או כישלון
    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        boolean isVerified = false;
        String getTableCellResponse = getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);

        System.out.println("getTableCellTextByXpath response: " + getTableCellResponse);

        if (!getTableCellResponse.contains("ERROR")) {
            isVerified = getTableCellResponse.equals(expectedText);
        }

        return isVerified;
    }

    //פונקציית getTableCellTextByXpath אמורה להביא את הערך על ידי שימוש ב xpath וללא ריצה בלולאה על רשומות הטבלה
    //את ערך/ערכי החיפוש קחו ממקור חיצוני לבחירתכם: קובץ Properties, XML, Excel, CSV
    //TODO: Ask Product if this is the correct way this function was meant to be executed.
    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        String columnText;
        switch (searchColumn) {
            case 1:
                if (searchText.equals(properties.getProperty("TABLES_COMPANY_FIRST_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByFirstCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByFirstContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByFirstCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COMPANY_SECOND_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(BySecondCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(BySecondContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(BySecondCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COMPANY_THIRD_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByThirdCompany).getText();
                            break;

                        case 2:
                            columnText = table.findElement(ByThirdContact).getText();
                            break;

                        case 3:
                            columnText = table.findElement(ByThirdCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COMPANY_FOURTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByFourthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByFourthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByFourthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COMPANY_FIFTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(byFifthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(byFifthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(byFifthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COMPANY_SIXTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(BySixthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(BySixthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(BySixthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else {
                    columnText = "ERROR: for 'searchColumn' of: " + searchColumn + " matching text not found for: " + searchText;
                }
                break;
            case 2:
                if (searchText.equals(properties.getProperty("TABLES_CONTACT_FIRST_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByFirstCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByFirstContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByFirstCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_CONTACT_SECOND_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(BySecondCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(BySecondContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(BySecondCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_CONTACT_THIRD_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByThirdCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByThirdContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByThirdCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_CONTACT_FOURTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByFourthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByFourthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByFourthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_CONTACT_FIFTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(byFifthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(byFifthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(byFifthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_CONTACT_SIXTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(byFifthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(byFifthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(byFifthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else {
                    columnText = "ERROR: for 'searchColumn' of: " + searchColumn + " matching text not found for: " + searchText;
                }
                break;
            case 3:
                if (searchText.equals(properties.getProperty("TABLES_COUNTRY_FIRST_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByFirstCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByFirstContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByFirstCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COUNTRY_SECOND_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(BySecondCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(BySecondContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(BySecondCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COUNTRY_THIRD_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByThirdCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByThirdContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByThirdCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COUNTRY_FOURTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(ByFourthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(ByFourthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(ByFourthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COUNTRY_FIFTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(byFifthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(byFifthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(byFifthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else if (searchText.equals(properties.getProperty("TABLES_COUNTRY_SIXTH_TEXT"))) {
                    switch (returnColumnText) {
                        case 1:
                            columnText = table.findElement(byFifthCompany).getText();
                            break;
                        case 2:
                            columnText = table.findElement(byFifthContact).getText();
                            break;
                        case 3:
                            columnText = table.findElement(byFifthCountry).getText();
                            break;
                        default:
                            columnText = "ERROR: The 'returnColumnText' value is not valid for: " + searchText;
                            break;
                    }
                } else {
                    columnText = "ERROR: for 'searchColumn' of: " + searchColumn + " matching text not found for: " + searchText;
                }
                break;
            default:
                columnText = "ERROR: The 'searchColumn' value is not valid, it have value of: " + searchColumn;
                break;
        }
        return columnText;
    }
}
