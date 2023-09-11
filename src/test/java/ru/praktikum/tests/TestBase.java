package ru.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public final static String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    protected WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
