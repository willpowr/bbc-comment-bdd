package com.willpoweru.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by willp on 22/06/2017.
 */
public class RegisterAgePage extends PageObject  {

    private final static String PAGE_URL =
            "https://account.bbc.com/register#comments";

    private int timeout = 15;


    @FindBy(id = "day-input")
    @CacheLookup
    private WebElement dayInput;

    @FindBy(id = "month-input")
    @CacheLookup
    private WebElement monthInput;

    @FindBy(id = "year-input")
    @CacheLookup
    private WebElement yearInput;

    @FindBy(id = "submit-button")
    @CacheLookup
    private WebElement submitButton;


    public RegisterAgePage(WebDriver driver) {
        super(driver);
    }



    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return boolean.
     */
    public boolean isCurrentUrl() {
        return driver.getCurrentUrl().contains(PAGE_URL);
    }


    public RegisterDetailsPage registerAge(String day, String month, String year){
        dayInput.sendKeys(day);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
        submitButton.click();
        return new RegisterDetailsPage(driver);
    }

}


