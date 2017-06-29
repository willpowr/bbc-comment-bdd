package com.willpoweru.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by willp on 28/06/2017.
 */
public class MoreDetailsPage  extends  PageObject{

    @FindBy(id = "displayName-input")
    //@CacheLookup
    private WebElement displayNameInput;

    @FindBy(id = "submit-button")
    @CacheLookup
    private WebElement submitButton;

    public MoreDetailsPage(WebDriver driver) {
        super(driver);
    }

    public NextStepsPage submitDisplayName(
            String displayName){
        displayNameInput.sendKeys(displayName);
        submitButton.click();
        return new NextStepsPage(driver);
    }



}
