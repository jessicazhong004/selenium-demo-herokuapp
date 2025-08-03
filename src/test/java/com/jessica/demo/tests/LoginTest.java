package com.jessica.demo.tests;

import com.jessica.demo.utils.WebDriverFactory;
import com.jessica.demo.utils.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.createDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // 等待 flash 消息出现
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

            if (flash.getText().contains("You logged into a secure area!")) {
                System.out.println("Login successful!");
                ScreenshotUtil.takeScreenshot(driver, "login_success");
            } else {
                System.out.println("Login failed!");
                ScreenshotUtil.takeScreenshot(driver, "login_failed");
            }

        } catch (Exception e) {
            System.out.println("Test error: " + e.getMessage());
            ScreenshotUtil.takeScreenshot(driver, "login_exception");
        } finally {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {}
            driver.quit();
        }
    }
}
