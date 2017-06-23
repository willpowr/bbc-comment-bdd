package com.willpoweru.bbc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CommentsTestPage extends  PageObject{

    @FindBy(css = "#blogs-main-content div.grid-wrapper div:nth-of-type(1) div.grid__inner div.island.br-box-page div:nth-of-type(2) article div:nth-of-type(1) div.cf div.pull--left.islet--vertical.text--shout a.blogs-comments-link")
    @CacheLookup
    private WebElement comments1;


    @FindBy(id = "comments")
    @CacheLookup
    private WebElement commentsSection;


    @FindBy(css = "#blogs-main-content div.grid-wrapper div:nth-of-type(1) div.grid__inner div.island.br-box-page div:nth-of-type(2) div:nth-of-type(1) div.cf div.pull--left.islet--vertical.text--shout a.blogs-comments-link")
    @CacheLookup
    private WebElement comments2;

    @FindBy(className = "cf")
    @CacheLookup
    private WebElement commentsLink2; //     driver.findElements(By.className("cf"));


    @FindBy(css = "a.id4-cta-registerLink")
    @CacheLookup
    private WebElement registerLink;


    @FindBy(id = "idcta-link")
    @CacheLookup
    private WebElement signIn1;

    @FindBy(css = "a.id4-cta-signin.id4-cta-button")
    @CacheLookup
    private WebElement signIn2;

    private WebElement signedInMessage(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bbc-blogs-comments-iframe");
        return driver.findElement(By.id("id4-cta-1"));
    }


    private WebElement commentInputBox(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bbc-blogs-comments-iframe");
        return driver.findElement(By.cssSelector("#submit_new_comment > textarea"));
    }


    private WebElement commentInputBoxByName(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bbc-blogs-comments-iframe");
        return driver.findElement(By.name("comment"));
    }


    private WebElement submitCommentButton(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bbc-blogs-comments-iframe");
        return driver.findElement(By.cssSelector("input.cmts-submit.cmts-button"));
    }


    private WebElement submissionMessage(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("bbc-blogs-comments-iframe");
        return driver.findElement(By.className("cmts-message"));
    }


    public CommentsTestPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Shows the Comments Section.
     *
     * @return boolean.
     */
    public boolean showsTheCommentsSection() {
        return commentsSection.isDisplayed();
    }

    /**
     * Shows the Comment Text Input box.
     *
     * @return boolean.
     */
    public boolean showsTheCommentInputBox() {
        return commentInputBox().isDisplayed();
    }


    public void enterComment(String comment) {
        commentInputBoxByName().sendKeys(comment);
        submitCommentButton().click();
    }

    /**
     * Click on Comments Link.
     *
     * @return the bbcTestComments class instance.
     */
    public CommentsTestPage clickComments2Link() {
        comments2.click();
        return this;
    }





    public WebElement iCanSeeTheCommentsLink() {
        WebElement result = comments1;
        return result;
    }

    /**
     * Click on Comments Link.
     *
     * @return the bbcTestComments class instance.
     */
    public CommentsTestPage clickComments1Link() {
        comments1.click();
        return this;
    }


    /**
     * Click on Sign In Link.
     *
     * @return the bbcTestComments class instance.
     */
    public SignInPage clickSignIn1Link() {
        signIn1.click();
        return new SignInPage(driver);
    }



    /**
     * Signed In Status Message.
     *
     * @return String.
     */
    public String signedInMessageText () {
        return signedInMessage().getText();
    }

    /**
     * Comment Submission Message.
     *
     * @return String.
     */
    public String submissionMessageText () {
        return submissionMessage().getText();
    }

}
