package com.jessica.demo.tests;

import com.jessica.demo.utils.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class GoogleTitleTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver("chrome");

    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        assertTrue("Title doesn't contain 'Google'", title.contains("Google"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}