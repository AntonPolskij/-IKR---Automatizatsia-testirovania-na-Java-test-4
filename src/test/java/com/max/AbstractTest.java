package com.max;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.LoginPage;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeEach
    abstract void init();

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
