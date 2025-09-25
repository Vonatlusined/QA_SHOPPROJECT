package com.onlineshop.test;

import com.shop.data.UserData;
import com.shop.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getCart().fillCartAdd();
    }

    @Test
    public void deleteCart() {
        app.getCart().deleteCart();
    }


}

