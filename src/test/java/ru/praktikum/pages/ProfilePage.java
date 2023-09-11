package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;
    private final By profileText = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By logoutButton = By.xpath("//button[@type='button']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидание видимости кнопки выход в личном кабинете
    public void waitVisibleLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    @Step("Нажать кнопку Выход")
    public void logoutButtonClick() {
        waitVisibleLogoutButton();
        driver.findElement(logoutButton).click();
    }

    //Ожидание видимости текста для авторизованного пользователя в личном кабинете
    public void waitVisibleProfileText() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }

    @Step("Проверить отображение текста в личном кабинете")
    public void shouldProfileText(String text) {
        waitVisibleProfileText();
        Assert.assertEquals("Текст не совпадает", text, driver.findElement(profileText).getText());
    }
}
