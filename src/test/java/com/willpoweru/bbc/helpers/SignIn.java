package com.willpoweru.bbc.helpers;

import com.willpoweru.bbc.pages.CommentsTestPage;
import com.willpoweru.bbc.pages.SignInPage;

/**
 * Created by willp on 22/06/2017.
 */
public class SignIn {
    private SignInPage signInPage;

    public void signIn(CommentsTestPage page, String userType){
        signInPage = page.clickSignIn1Link();

        if (userType.equals("old_enough")) {
            signInPage.signInUser("test1@willpoweru.com", "password123");
        } else if (userType.equals("too_young")) {
            signInPage.signInUser("aa-", "password123");
        }
    }
}
