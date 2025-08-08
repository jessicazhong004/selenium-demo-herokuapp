package com.jessica.demo.tests;

import com.jessica.demo.utils.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

public class CheckboxTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void testFirstCheckbox() {
        WebElement firstCheckbox = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        if (!firstCheckbox.isSelected()) {
            firstCheckbox.click();
            System.out.println("First checkbox was not selected, now it's selected.");
        } else {
            System.out.println("First checkbox was already selected.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
