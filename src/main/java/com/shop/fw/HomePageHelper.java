package com.shop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean homeComponentPresent(){
        return elementPresent(By.cssSelector("a[href='/']"));
    }

    public void clickOnHomeLink() {
        click(By.cssSelector("a[href='/']"));
    }
}
