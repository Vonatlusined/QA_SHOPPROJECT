package com.onlineshop.test;

import com.shop.data.UserData;
import com.shop.models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CreateAccountTest extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnRegistrationLink(); // клик на кнопку регистрации

        app.getUser().fillRegisterLoginForm(UserData.EMAIL, UserData.PASSWORD, UserData.NAME, UserData.LASTNAME);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isSignOutButton());
    }



//    @Test(dataProvider = "AddNewUser",dataProviderClass = DataProviders.class)
//    public void newUserRegistrationFromDataProviderPositiveTest(String email
//            , String password
//            , String name
//            , String lastName) {
//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//        app.getUser().clickOnLoginLink();
//        app.getUser().clickOnRegistrationLink();
//
//        app.getUser().fillRegisterLoginForm(
//                email,
//                password,
//                name,
//                lastName);
//        app.getUser().clickOnRegistrationButton();
//
//        Assert.assertTrue(app.getUser().isSignOutButton());
//    }




//    @Test(dataProvider = "addNewUserWithScv",dataProviderClass = DataProviders.class)
//    public void newUserRegistrationFromDataProviderWithCsvFilePositiveTest(UserData user) {
//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//        app.getUser().clickOnLoginLink();
//        app.getUser().clickOnRegistrationLink();
//
//        app.getUser().fillRegisterLoginForm();
//        app.getUser().clickOnRegistrationButton();
//
//        Assert.assertTrue(app.getUser().isSignOutButton());
//    }

    @Test(priority = 2)
    public void existUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();

        app.getUser().fillRegisterLoginForm(UserData.EMAIL, UserData.PASSWORD, UserData.NAME, UserData.LASTNAME);

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().elementPresent(EmailExsistMessage()));

    }

}
