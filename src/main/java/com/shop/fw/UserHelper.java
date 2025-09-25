package com.shop.fw;

import com.shop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {


    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        driver.findElement(By.cssSelector("[id=\"register-button\"]")).click();
    }

    public void fillRegisterLoginForm(String email, String password, String firsName, String lastName) {
        driver.findElement(By.cssSelector("[id=\"gender-male\"]")).click(); //выбор гендера

        type(By.cssSelector("[id$='FirstName']"), firsName);

        type(By.cssSelector("[id=\"LastName\"]"), lastName);

        type(By.cssSelector("[id=\"Email\"]"), email);


        type(By.cssSelector("[id=\"Password\"]"), password);

        type(By.cssSelector("[id=\"ConfirmPassword\"]"), password);
    }

    public void clickOnRegistrationLink() {

        driver.findElement(By.cssSelector("[href='/register']")).click();
    }

    public void fillLoginForm(User user) {
        type(By.xpath("(//input[@id='Email'])[1]"), user.getEmail());

        type(By.xpath("(//input[@id='Password'])[1]"), user.getPassword());
    }

    public void clickOnLoginLink() {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
    }
    public boolean isSignOutButton() {
        return elementPresent(By.xpath("//a[normalize-space()='Log out']"));
    }


}
