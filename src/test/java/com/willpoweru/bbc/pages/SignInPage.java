package com.willpoweru.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by willp on 21/06/2017.
 */
public class SignInPage extends PageObject {

    private final static String PAGE_URL =
            "https://account.bbc.com/signin#comments";

    private int timeout = 15;

    @FindBy(css = "#signin-page")
    @CacheLookup
    private WebElement signInPageDiv;


    @FindBy(id = "username-input")
    @CacheLookup
    private WebElement usernameInput;


    @FindBy(id = "password-input")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(id = "form-error-username")
    @CacheLookup
    private WebElement usernameError;

    @FindBy(id = "form-error-password")
    @CacheLookup
    private WebElement passwordError;

    @FindBy(id = "submit-button")
    @CacheLookup
    private WebElement submitButton;


    public SignInPage(WebDriver driver) {
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


    public void signInUser(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
        new CommentsTestPage(driver);
    }

    /**
     * Shows the Username Error.
     *
     * @return boolean.
     */
    public boolean showsTheUserNameError() {
        return usernameError.isDisplayed();
    }

    public boolean showsThePasswordError() { return passwordError.isDisplayed(); }
}
