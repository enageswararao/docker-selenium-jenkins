package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    WebDriver driver = null;

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void test_login() throws InterruptedException {
        System.out.println("After loading print current Url  " +driver.getCurrentUrl());

        driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(5000);
        System.out.println("After login print current Url  " +driver.getCurrentUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
