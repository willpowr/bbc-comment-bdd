package com.willpoweru.bbc.unit_tests;

import com.willpoweru.bbc.helpers.Register;
import com.willpoweru.bbc.pages.CommentsTestPage;
import com.willpoweru.bbc.pages.RegisterAgePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by willp on 25/06/2017.
 */
public class RegisterUserTest {
    private final static String PAGE_URL =
            "http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0#comments";
    private RegisterAgePage registerAgePage;

    @Test

    public void testSetDateFields() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\dev\\utils\\browser_drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        Register register = new Register();
        register.registerUser(new CommentsTestPage(driver), Register.Age.NEW_ADULT);
    }




}