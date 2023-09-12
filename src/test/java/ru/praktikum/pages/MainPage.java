package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final By authAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By loginHeader = By.xpath("//h2[text()='Вход']");
    private final By inputEmail = By.xpath("//label[text()='Email']/following::input");
    private final By inputPassword = By.xpath("//input[@type='password']");
    private final By authButton = By.xpath("//button[text()='Войти']");
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By personalAreaButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By forgotPasswordLink = By.xpath("//a[@href='/forgot-password']");
    private static final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private static final By logoButton = By.xpath("//a[@href='/']");
    private final By burgerTitle = By.xpath("//h1[text()='Соберите бургер']");
    private final By bunSection = By.xpath("//span[text()='Булки']");
    private final By bunText = By.xpath("//div[span[text()='Булки']]");
    private final By souseSection = By.xpath("//span[text()='Соусы']");
    private final By souseText = By.xpath("//div[span[text()='Соусы']]");
    private final By fillingSection = By.xpath("//span[text()='Начинки']");
    private final By fillingText = By.xpath("//div[span[text()='Начинки']]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на вкладку с Булками")
    public void clickBunSection() {
        driver.findElement(bunSection).click();
    }

    @Step("Нажать на вкладку с Соусами")
    public void clickSouseSection() {
        driver.findElement(souseSection).click();
    }

    @Step("Нажать на вкладку с Начинками")
    public void clickFillingSection() {
        driver.findElement(fillingSection).click();
    }

    @Step("Проверить, что вкладка с Булками активна")
    public void shouldBunSection() {
        Assert.assertTrue(driver.findElement(bunText).getAttribute("class").contains("current"));
    }

    @Step("Проверить, что вкладка с Соусами активна")
    public void shouldSouseSection() {
        Assert.assertTrue(driver.findElement(souseText).getAttribute("class").contains("current"));
    }

    @Step("Проверить, что вкладка с Начинками активна")
    public void shouldFillingSection() {
        Assert.assertTrue(driver.findElement(fillingText).getAttribute("class").contains("current"));
    }

    public static By getConstructorButton(){
        return constructorButton;
    }

    public static By getLogoButton(){
        return logoButton;
    }

    @Step("Перейти из личного кабинета в конструктор")
    public void navigateToConstructor (By element) {
        driver.findElement(element).click();
    }

    //Ожидание видимости заголовка конструктора
    public void waitVisibleBurgerTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerTitle));
    }

    @Step("Проверить отображение заголовка конструктора 'Соберите бургер'")
    public void shouldBurgerTitle(String text) {
        waitVisibleBurgerTitle();
        Assert.assertEquals("Текст не совпадает", text, driver.findElement(burgerTitle).getText());
    }


    //Ожидание видимости ссылки "Восстановить пароль"
    public void waitVisibleForgotPasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));
    }

    @Step("Нажать ссылку Восстановить пароль")
    public void forgotPasswordLinkClick() {
        waitVisibleForgotPasswordLink();
        driver.findElement(forgotPasswordLink).click();
    }

    //Ожидание видимости кнопки "Личный кабинет" после перехода на главную страницу
    public void waitVisiblePersonalAreaButton() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAreaButton));
    }

    @Step("Нажать кнопку Личный кабинет")
    public void personalAreaButtonClick() {
        waitVisiblePersonalAreaButton();
        driver.findElement(personalAreaButton).click();
    }

    //Ожидание видимости кнопки "Войти в аккаунт" после перехода на главную страницу
    public void waitVisibleAuthAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(authAccountButton));
    }

    @Step("Нажать кнопку Войти в аккаунт на главной")
    public void authAccountButtonClick() {
        waitVisibleAuthAccountButton();
        driver.findElement(authAccountButton).click();
    }

    //Ожидание видимости формы авторизации после нажатия на кнопку "Войти в аккаунт"
    public void waitVisibleLoginHeader() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
    }

    @Step("Заполнить поле Email")
    public void emailSetValue(String email) {
        waitVisibleLoginHeader();
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void passwordSetValue(String password) {
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void authButtonClick() {
        driver.findElement(authButton).click();
    }

    //Ожидание видимости кнопки оформить заказ после успешной авторизации
    public void waitVisibleCreateOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    @Step("Проверить отображение кнопки 'Оформить заказ' после успешной авторизации")
    public void shouldCreateOrderButton(String text) {
        waitVisibleCreateOrderButton();
        Assert.assertEquals("Текст не совпадает", text, driver.findElement(createOrderButton).getText());
    }

    @Step("Проверить отображение формы авторизации после выхода")
    public void shouldAuthText(String text) {
        waitVisibleLoginHeader();
        Assert.assertEquals("Вход", text, driver.findElement(loginHeader).getText());
    }




}
