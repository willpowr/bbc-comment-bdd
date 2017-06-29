package com.willpoweru.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by willp on 22/06/2017.
 */
public class RegisterDetailsPage extends PageObject  {

    private final static String PAGE_URL =
            "https://account.bbc.com/register/details";

    private int timeout = 15;


    @FindBy(id = "email-input")
    @CacheLookup
    private WebElement emailInput;

    @FindBy(id = "username-input")
    @CacheLookup
    private WebElement usernameInput;

    @FindBy(id = "password-input")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(id = "postcode-input")
    @CacheLookup
    private WebElement postcodeInput;

    @FindBy(id = "hometown-input")
    @CacheLookup
    private WebElement hometownInput;

    @FindBy(id = "gender-input")
    @CacheLookup
    private WebElement gender;

    @FindBy(css = "#marketingOptIn > div.buttons__wrapper > div:nth-child(1)")
    @CacheLookup
    private WebElement optInButton;

    @FindBy(css = "#marketingOptIn > div.buttons__wrapper > div:nth-child(2)")
    @CacheLookup
    private WebElement optOutButton;

    @FindBy(id = "submit-button")
    @CacheLookup
    private WebElement submitButton;


    public RegisterDetailsPage(WebDriver driver) {
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



    public RegisterThanksPage registerDetailsChild(
            String username, String password, String hometown, String genderValue){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        hometownInput.sendKeys(hometown);
        new Select(gender).selectByVisibleText(genderValue);
        submitButton.click();
        return new RegisterThanksPage(driver);
    }


    public RegisterThanksPage registerDetails(
            String email, String password, String hometown, String genderValue){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        hometownInput.sendKeys(hometown);
        new Select(gender).selectByVisibleText(genderValue);
        optOutButton.click();
        submitButton.click();
        return new RegisterThanksPage(driver);
    }

    public RegisterThanksPage registerDetailsAdolescent(
            String email, String password, String hometown, String genderValue){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        hometownInput.sendKeys(hometown);
        new Select(gender).selectByVisibleText(genderValue);
        optOutButton.click();
        submitButton.click();
        return new RegisterThanksPage(driver);
    }

    public RegisterThanksPage registerDetailsAdult(
            String email, String password, String postcode, String genderValue){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        postcodeInput.sendKeys(postcode);
        new Select(gender).selectByVisibleText(genderValue);
        optOutButton.click();
        submitButton.click();
        return new RegisterThanksPage(driver);
    }


}


