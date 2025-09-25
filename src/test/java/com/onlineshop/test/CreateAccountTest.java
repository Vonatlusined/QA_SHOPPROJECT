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

    @DataProvider
    public Iterator<Object[]> AddNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"John123@email.com", "John1234.", "John", "Smitt",});
        list.add(new Object[]{"John65@email.com", "John123456.", "Carl", "Smitt",});
        list.add(new Object[]{"John88@email.com", "John12345678.", "Joe", "Smitt",});
        list.add(new Object[]{"John33@email.com", "John12344321.", "Sara", "Carol",});
        return list.iterator();
    }

    @Test(dataProvider = "AddNewUser")
    public void newUserRegistrationFromDataProviderPositiveTest(String email
            , String password
            , String name
            , String lastName) {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnRegistrationLink();

        app.getUser().fillRegisterLoginForm(
                email,
                password,
                name,
                lastName);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isSignOutButton());
    }



    @DataProvider
    public Iterator<Object[]>addNewUserWithScv() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/Users.csv")));

        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");

            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});

            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewUserWithScv")
    public void newUserRegistrationFromDataProviderWithCsvFilePositiveTest(String email
            , String password
            , String name
            , String lastName) {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnRegistrationLink();

        app.getUser().fillRegisterLoginForm(
                email,
                password,
                name,
                lastName);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isSignOutButton());
    }

    @Test(priority = 2)
    public void existUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();

        app.getUser().fillRegisterLoginForm(UserData.EMAIL, UserData.PASSWORD, UserData.NAME, UserData.LASTNAME);

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().elementPresent(EmailExsistMessage()));

    }

}
