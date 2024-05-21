package com.max;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.LoginPage;

import java.util.concurrent.TimeUnit;

public class UITest extends AbstractTest{
    private WebDriver driver;

    private LoginPage loginPage;
    private static String USERNAME;
    private static String PASSWORD;


    @BeforeAll
    public static void setupClass() {
        USERNAME = "login";
        PASSWORD = "password";
    }

    @BeforeEach
    void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://gb.ru/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    void testGBNotEmailLogin() {
            loginPage.login(USERNAME,PASSWORD);
            Assertions.assertEquals("Введите адрес электронной почты.",loginPage.getLoginInputInfo());
    }

    @Test
    void testGBWithoutPassword() {
            loginPage.typeLoginInField(USERNAME);
            loginPage.clickLoginButton();
            Assertions.assertEquals("Обязательное поле.",loginPage.getPasswordInputInfo());
    }

    @Override
    @AfterEach
    public void teardown() {
        driver.quit();
    }

}
