package com.willpoweru.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by willp on 28/06/2017.
 */
public class NextStepsPage extends PageObject{

    @FindBy(css = "a.button.button--full-width.button--big-top")
    //@CacheLookup
    private WebElement continueButton;

    public NextStepsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on Continue Link.
     *
     * @return the bbcTestCommentsThanks class instance.
     */
    public NextStepsPage clickContinueButton() {
        continueButton.click();
        return this;
    }

}
