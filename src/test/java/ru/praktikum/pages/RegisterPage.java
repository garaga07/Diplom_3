package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final  WebDriver driver;
    private final By registerLink = By.xpath("//a[@href='/register']");
    private final By inputName = By.xpath("//input[@name='name']");
    private final By inputEmail = By.xpath("//label[text()='Email']/following::input");
    private final By inputPassword = By.xpath("//input[@type='password']");
    private final By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    private final By passwordValidationErrorMsg = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginHeader = By.xpath("//h2[text()='Вход']");
    private final By authLink = By.xpath("//a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидание видимости ссылки "Зарегистрироваться" после перехода на форму авторизации
    public void waitVisibleRegisterLink() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerLink));
    }

    @Step("Нажать ссылку Зарегистрироваться")
    public void registerLinkClick() {
        waitVisibleRegisterLink();
        driver.findElement(registerLink).click();
    }

    //Ожидание видимости ссылки Войти на форме регистрации
    public void waitVisibleAuthLink() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(authLink));
    }

    @Step("Нажать ссылку Войти")
    public void authLinkClick() {
        waitVisibleAuthLink();
        driver.findElement(authLink).click();
    }

    //Ожидание видимости поля Имя на форме регистрации
    public void waitVisibleInputName() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputName));
    }

    @Step("Заполнить поле Имя")
    public void nameSetValue(String name) {
        waitVisibleInputName();
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("Заполнить поле Email")
    public void emailSetValue(String email) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void passwordSetValue(String password) {
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
    }
    @Step("Нажать кнопку Зарегистрироваться")
    public void buttonRegisterClick() {
        driver.findElement(buttonRegister).click();
    }

    //Ожидание видимости формы авторизации после успешной регистрации
    public void waitVisibleLoginHeader() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
    }

    @Step("Проверить переход на форму авторизации после успешной регистрации")
    public void shouldAuthText(String text) {
        waitVisibleLoginHeader();
        Assert.assertEquals("Текст не совпадает", text, driver.findElement(loginHeader).getText());
    }

    //Ожидание видимости сообщения о некорректном пароле
    public void waitVisiblePasswordValidationErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordValidationErrorMsg));
    }

    @Step("Проверить отображение ошибки валидации для поля пароль")
    public void checkIncorrectPasswordError(String text) {
        waitVisiblePasswordValidationErrorMsg();
        Assert.assertEquals("Текст не совпадает", text, driver.findElement(passwordValidationErrorMsg).getText());
    }

}