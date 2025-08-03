package com.jessica.demo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        String browser = getBrowserFromConfig();  // 从配置文件获取
        return createDriver(browser);
    }

    public static WebDriver createDriver(String browser) {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    private static String getBrowserFromConfig() {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }

        return props.getProperty("browser", "chrome"); // 如果没写就默认chrome
    }
}
