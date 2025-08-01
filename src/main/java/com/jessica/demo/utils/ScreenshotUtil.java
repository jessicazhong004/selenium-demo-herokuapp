package com.jessica.demo.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            FileHandler.copy(src, new File("screenshots/" + name + "_" + timestamp + ".png"));
            System.out.println("📸 Screenshot saved as: " + name + "_" + timestamp + ".png");
        } catch (Exception e) {
            System.out.println("❌ Failed to take screenshot: " + e.getMessage());
        }
    }
}
