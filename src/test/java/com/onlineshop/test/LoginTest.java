package com.onlineshop.test;

import com.shop.data.UserData;
import com.shop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void LoginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm((new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButton());
    }

    @Test()
    public void LoginNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().elementPresent(isErrorMessage()));

    }

}