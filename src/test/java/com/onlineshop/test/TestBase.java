package com.onlineshop.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

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

    public void fillLoginForm(User user) {
        type(By.xpath("(//input[@id='Email'])[1]"), user.email());

        type(By.xpath("(//input[@id='Password'])[1]"), user.password());
    }

    public void clickOnLoginLink() {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
    }

    public void fillCartAdd() {
        driver.findElement(By.cssSelector("div[class='product-item'] a[title='Show details for 14.1-inch Laptop']")).click();
        clickOnAddCartButton();
    }

    public void clickOnAddCartButton() {
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button-31'])[1]")).click();
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacs = driver.findElements(By.cssSelector("p[class='content'] a"));
        for (WebElement element : contacs) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void deleteContact() {
        driver.findElement(By.cssSelector("li[id='topcartlink'] a[class='ico-cart']")).click();
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.cssSelector("input[value='Update shopping cart']")).click();
    }
}
