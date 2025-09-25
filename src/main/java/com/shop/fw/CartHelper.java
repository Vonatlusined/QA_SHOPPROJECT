package com.shop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartHelper extends BaseHelper {
    public CartHelper(WebDriver driver) {
        super(driver);
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

    public void deleteCart() {
        driver.findElement(By.cssSelector("li[id='topcartlink'] a[class='ico-cart']")).click();
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.cssSelector("input[value='Update shopping cart']")).click();
    }
}
