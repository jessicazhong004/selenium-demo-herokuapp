package com.jessica.demo.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.jessica.demo.utils.WebDriverFactory;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class UploadFileTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void testFileUpload() {
        WebElement uploadInput = driver.findElement(By.id("file-upload"));

        WebElement uploadButton = driver.findElement(By.id("file-submit"));

        File file = new File("screenshots/test.txt");
        String absolutePath = file.getAbsolutePath();
        uploadInput.sendKeys(absolutePath);

        uploadButton.click();

        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        assertTrue("Upload failure!", uploadedMessage.getText().contains("File Uploaded!"));

        System.out.println("✅ Upload success!");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}