package com.onlineshop.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean homeComponentPresent(){
        return driver.findElements(By.cssSelector("a[href='/']")).size()>0;
    }

    public boolean elementPresent (By locator){
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text); //клик и заполнение поля Email
    }

    public void click(By locator) {
        driver.findElement(locator);
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

    public boolean isSignOutButton() {
        return elementPresent(By.xpath("//a[normalize-space()='Log out']"));
    }

    public void clickOnLoginLink() {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
    }
}
