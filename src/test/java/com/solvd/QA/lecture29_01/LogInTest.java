package com.solvd.QA.lecture29_01;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTest {

    @BeforeSuite
    public void setup() {
    }

    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][]{
                {"email1", "password1"},
                {"email2", "password2"}
        };
    }


    @Test(description = "Verify login valid credential", dataProvider = "validCredentials")
    public void verifyLoginWithValidCredentialsTest(String email, String password) {
        boolean emailInputExists = true;
        boolean passwordInputExists = false;
        Assert.assertTrue(emailInputExists, "Email input doesn't exist");
        Assert.assertTrue(passwordInputExists, "Password input doesn't exist");
//        Assert.assertFalse(false);
//        Assert.assertNull();
//        Assert.assertNotNull();
//
//        String expectedTitle="Log in";
//        String actualTitle="Log in";
//        Assert.assertEquals(actualTitle, expectedTitle, "Log in screen title incorrect");
//        Assert.assertNotEquals();
//
//        SoftAssert sa = new SoftAssert();
//        sa.assertEquals("acrual", "espected", "message");
//        sa.assertEquals("acrual1", "espected1", "message1");
//        sa.assertAll();
    }

    @Test(description = "Verify login invalid credential")
    public void verifyLoginWithInvalidCredentialsTest() {
        System.out.println("Hello world");
    }
}
