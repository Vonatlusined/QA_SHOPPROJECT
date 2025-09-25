package com.onlineshop.test;

import com.shop.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Start test"+ method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()){
            logger.info("PASSED: "+result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: "+result.getMethod()
                    .getMethodName()+" Screenshot path: "+app.getUser()
                    .takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("********************************************************");
    }

    public By EmailExsistMessage() {
        return By.xpath("//li[normalize-space()='The specified email already exists']");
    }

    public String getShoppingCart() {
        return "shopping cart";
    }

    protected By isErrorMessage() {
        return By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
    }
}
