package com.willpoweru.bbc.helpers;

import com.willpoweru.bbc.pages.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by willp on 25/06/2017.
 */
public class Register {

    private static final int CHILD_TO_AGE = 12;
    private static final int TEEN_FROM_AGE = 13;
    private static final int TEEN_TO_AGE = 15;
    private static final int ADOLESCENT_FROM_AGE = 16;
    private static final int ADOLESCENT_TO_AGE = 17;
    private static final int ADULT_FROM_AGE = 18;


    private static final long ONE_DAY = 1000 * 60 * 60 * 24;
    private static final String EMAIL_DOMAIN = "@test.com";
    private static final String PASSWORD = "password123";
    private static final String POSTCODE = "W1A 1AA";
    private static final String GENDER = "Male";
    private static final String HOMETOWN = "london";

    private RegisterAgePage registerAgePage;
    private RegisterDetailsPage registerDetailsPage;
    private RegisterThanksPage registerThanksPage;
    private MoreDetailsPage moreDetailsPage;
    private NextStepsPage nextStepsPage;

    private String mUsername;
    private String mEmail;

    public enum Age {
        PRE_TEEN (TEEN_FROM_AGE, ONE_DAY),
        NEW_TEEN(TEEN_FROM_AGE, 0),
        PRE_ADOLESCENT (ADOLESCENT_FROM_AGE, ONE_DAY),
        NEW_ADOLESCENT (ADOLESCENT_FROM_AGE, 0),
        PRE_ADULT (ADULT_FROM_AGE, ONE_DAY),
        NEW_ADULT (ADULT_FROM_AGE, 0);

        private final int years;
        private final long days;

        Age(int years, long days){
            this.years = years;
            this.days =days;
        }

        Calendar getDob(){
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, c.get(Calendar.YEAR) - years);
            c.setTimeInMillis(c.getTimeInMillis() + days);
            return c;
        }

        String day(){
            System.out.println("Date of birth = " + getDob().getTime());
            return Integer.toString(getDob().get(Calendar.DAY_OF_MONTH));
        }

        String month(){
            return Integer.toString(getDob().get(Calendar.MONTH)+1);
        }

        String year(){
            return Integer.toString(getDob().get(Calendar.YEAR));
        }
    }


    public void registerUser(CommentsTestPage commentsTestPage, Age age){
        setUserIdFields(age);

        registerAgePage = commentsTestPage.clickRegisterLink();
        registerDetailsPage = registerAgePage.registerAge(
                age.day(), age.month(), age.year());

        switch (age){
            case PRE_TEEN:
                registerThanksPage = registerDetailsPage.registerDetailsChild(
                        mUsername, PASSWORD, HOMETOWN, GENDER);
                nextStepsPage = registerThanksPage.clickContinueButton();
                nextStepsPage.clickContinueButton();
                break;

            case NEW_TEEN:
            case PRE_ADOLESCENT:
                registerThanksPage = registerDetailsPage.registerDetails(
                        mEmail, PASSWORD, HOMETOWN, GENDER);
                nextStepsPage = registerThanksPage.clickContinueButton();
                nextStepsPage.clickContinueButton();
                break;

            case NEW_ADOLESCENT:
            case PRE_ADULT:
                registerThanksPage = registerDetailsPage.registerDetails(
                        mEmail, PASSWORD, HOMETOWN, GENDER);
                moreDetailsPage = registerThanksPage.clickContinueButtonOlderUser();
                nextStepsPage = moreDetailsPage.submitDisplayName(mUsername);
                nextStepsPage.clickContinueButton();
                break;

            case NEW_ADULT:
                registerThanksPage = registerDetailsPage.registerDetailsAdult(
                        mEmail, PASSWORD, POSTCODE, GENDER);
                moreDetailsPage = registerThanksPage.clickContinueButtonOlderUser();
                nextStepsPage = moreDetailsPage.submitDisplayName(mUsername);
                nextStepsPage.clickContinueButton();
        }
    }

    private  void setUserIdFields(Age ageGroup){
        String userPrefix = ageGroup.name();
        String timeStamp = new SimpleDateFormat("yyMMdd_HHmmss")
                .format(Calendar.getInstance().getTime());
        mUsername = userPrefix + timeStamp;
        mEmail = userPrefix + timeStamp + EMAIL_DOMAIN;
    }

}
