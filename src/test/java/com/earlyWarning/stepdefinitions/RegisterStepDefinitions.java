package com.earlyWarning.stepdefinitions;

import com.earlyWarning.pageObjects.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class RegisterStepDefinitions extends UIInteractionSteps {

    RegisterPage registerPage;
//    List<User> users = ReadFromExcel.getUsers();

    @Given("I am on the Registration page")
    public void iAmOnTheRegistrationPage() {
        getDriver().manage().window().maximize();
        registerPage.open();
    }

    @When("I click on Create Account button")
    public void iClickOnCreateAccountButton() throws Throwable{
        registerPage.createAccountButton.waitUntilEnabled();
        registerPage.createAccountButton.waitUntilClickable();
        Thread.sleep(1999);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,250)");
        Actions action = new Actions(getDriver());
        action.moveToElement(registerPage.createAccountButton).build().perform();
        registerPage.createAccountButton.click();
    }

    @Then("I should see following message on the Registration page")
    public void iShouldSeeFollowingMessageOnTheRegistrationPage(DataTable table) {
        waitABit(1999);
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            Assert.assertEquals("Didn'show any message for " + columns.get("Field Name") + " field.",
                    columns.get("Message"), registerPage.errorMessage.waitUntilVisible().getText());
        }
    }

    @When("I enter value on {string} field")
    public void iEnterValueOnField(String fieldName) {
//        registerPage.enterValueInField(fieldName, users.get(0).getValue(fieldName));
//        registerPage.enterValueInField(fieldName, users.get(0).getValue(fieldName));
    }

    @When("I fill registration form using {int} row of the excel file")
    public void iFillRegistrationFormUsingStRowOfTheExcelFile(int rowNumber) {
//        int actualRowNumber = rowNumber - 1;
//        User user = users.get(actualRowNumber);
        registerPage.enterValueInField("First Name", "Daniel");
        registerPage.enterValueInField("Last Name", "Zumei");
        registerPage.enterValueInField("Email", "Daniel.zuemui@earlywarning.com");
//        registerPage.enterValueInField("Phone", user.getValue("Phone"));
//        registerPage.enterValueInField("Company Name", user.getValue("Company Name"));
//        registerPage.enterValueInField("Company Website", user.getValue("Company Website"));
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        WebElement elm = getDriver().findElement(By.xpath("//span[text()='" + message + "']"));
        Assert.assertTrue("Didn'show any " + message + " message.",
                elm.isDisplayed());
    }

    @When("I click on {string} link on the Registration page")
    public void iClickOnLinkOnTheRegistrationPage(String linkName) {
        WebElement elm = getDriver().findElement(By.xpath("//a[contains(text(),'" + linkName + "')]"));
        elm.click();
    }


    @Then("I should see a popup")
    public void iShouldSeeAPopup() {
        registerPage.okButtonOnModelPopup.waitUntilVisible();
        Assert.assertTrue("Popup is not displayed", registerPage.okButtonOnModelPopup.isDisplayed());
    }

    @Then("I close the popup")
    public void iCloseThePopup() {
        registerPage.okButtonOnModelPopup.click();
        registerPage.okButtonOnModelPopup.waitUntilNotVisible();
    }

    @When("I enter value {string} on {string} field")
    public void iEnterValueOnField(String value, String fieldName) {
        registerPage.enterValueInField(fieldName, value);
    }
}
