package com.earlyWarning.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("page:register.page")
public class RegisterPage extends PageObject {

    @FindBy(xpath = "//button/span[text()='CREATE ACCOUNT']")
    public WebElementFacade createAccountButton;

    @FindBy(id = "error")
    public WebElementFacade errorMessage;

    @FindBy(css = "button[title='OK']")
    public WebElementFacade okButtonOnModelPopup;

    public void enterValueInField(String fieldName, String value) {
        if(value != null) {
            WebElement elm = getDriver().findElement(By.cssSelector("input[placeholder='" + fieldName + "']"));
            elm.clear();
            elm.sendKeys(value);
        }
    }

}
