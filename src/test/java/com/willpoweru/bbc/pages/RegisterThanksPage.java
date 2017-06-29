package com.willpoweru.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by willp on 22/06/2017.
 */
public class RegisterThanksPage extends PageObject  {

    private final static String PAGE_URL =
            "https://account.bbc.com/register/thanks";

    private int timeout = 15;


    @FindBy(css = "a.button.button--full-width.button--big-top")
    //@CacheLookup
    private WebElement continueButton;




    public RegisterThanksPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Click on Continue Link.
     *
     * @return the bbcTestCommentsThanks class instance.
     */
    public NextStepsPage clickContinueButton() {
        continueButton.click();
        return new NextStepsPage(driver);
    }

    /**
     * Click on Continue Link.
     *
     * @return the bbcTestCommentsThanks class instance.
     */
    public MoreDetailsPage clickContinueButtonOlderUser() {
        continueButton.click();
        return new MoreDetailsPage(driver);
    }
    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return boolean.
     */
    public boolean isCurrentUrl() {
        return driver.getCurrentUrl().contains(PAGE_URL);
    }




}


