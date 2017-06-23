package com.willpoweru.bbc.features.steps;

import com.willpoweru.bbc.helpers.RandomText;
import com.willpoweru.bbc.helpers.SignIn;
import com.willpoweru.bbc.pages.CommentsTestPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by willp on 22/06/2017.
 */
public class CommentStepdefs{
    private static final Logger LOGGER = Logger.getLogger(CommentStepdefs.class.getName());
    private final static String PAGE_URL =
            "http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0#comments";
    private CommentsTestPage commentsTestPage;
    protected static WebDriver driver;



    @Before
    public static void setUp(){
        LOGGER.info("Entering: Set up");
        System.setProperty("webdriver.chrome.driver",
                "C:\\dev\\utils\\browser_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        LOGGER.info("Entering Clean Up...");
        driver.manage().deleteAllCookies();
        driver.close();
    }




    @Given("^I am on a commentable page$")
    public void i_am_on_a_commentable_page() throws Throwable {
        LOGGER.info("Entering: I am on a commentable page");
        driver.get(PAGE_URL);
        commentsTestPage = new CommentsTestPage(driver);
        assert(commentsTestPage.showsTheCommentsSection());
    }


    @When("^a user who is \"([^\"]*)\" signs in to work with comments$")
    public void a_user_signs_in_to_work_with_comments(String userAge) throws Throwable {
        LOGGER.info("Entering: A user who is " + userAge + " signs in to work with comments");
        new SignIn().SignIn(commentsTestPage, userAge);
    }

    @Then("^a comment sign in status message \"([^\"]*)\" is shown$")
    public void a_comment_sign_in_status_message_is_shown(String expectedMessage) throws Throwable {
        LOGGER.info("Entering: A comment sign in status message " + expectedMessage + " is shown");
        assertThat(commentsTestPage.signedInMessageText(), containsString(expectedMessage));
    }


    @Given("^a user old enough to comment is signed in$")
    public void a_user_old_enough_to_comment_is_signed_in() throws Throwable {
        LOGGER.info("a user old enough to comment is signed in");
        new SignIn().SignIn(commentsTestPage, "old_enough");
    }

    @When("^a user enters a comment \"([^\"]*)\"$")
    public void a_user_enters_a_comment(String comment) throws Throwable {
        LOGGER.info("Entering: A user enters a comment | " + comment + " |");
        if (comment.contains("valid")) {comment = "A valid comment " + RandomText.makeText();}
        commentsTestPage.enterComment(comment);
    }

    @Then("^a comment submission message \"([^\"]*)\" is shown$")
    public void a_comment_submission_message_is_shown(String submissionMessage) throws Throwable {
        LOGGER.info("Entering: A comment submission message | " + submissionMessage + " | is shown");
        assertThat(commentsTestPage.submissionMessageText(), containsString(submissionMessage));
    }


}
