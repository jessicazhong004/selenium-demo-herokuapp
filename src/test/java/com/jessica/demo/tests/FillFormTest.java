package com.jessica.demo.tests;

import com.jessica.demo.utils.ScreenshotUtil;
import com.jessica.demo.utils.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillFormTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
    }

    @Test
    public void fillOutForm() {
        driver.findElement(By.name("first_name")).sendKeys("Jessica");
        driver.findElement(By.name("last_name")).sendKeys("Zhong");
        driver.findElement(By.name("email")).sendKeys("jessica@example.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("address")).sendKeys("123 Test St");
        driver.findElement(By.name("city")).sendKeys("Toronto");
        driver.findElement(By.name("state")).sendKeys("Ontario");
        driver.findElement(By.name("zip")).sendKeys("A1B2C3");
        driver.findElement(By.name("website")).sendKeys("https://jessica.dev");
        driver.findElement(By.name("comment")).sendKeys("This is a test message.");

        WebElement hostingYes = driver.findElement(By.xpath("//input[@name='hosting' and @value='yes']"));
        hostingYes.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        ScreenshotUtil.takeScreenshot(driver, "form_submitted");


        System.out.println("Form submitted!");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
