package ru.praktikum.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.RegisterPage;

@Feature("Авторизация пользователя")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Тесты на авторизацию пользователя")
public class AuthTest extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация по кнопке «Войти в аккаунт» на главной")
    public void accountAuthTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.authAccountButtonClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.shouldCreateOrderButton("Оформить заказ");
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация по кнопке «Личный кабинет» на главной")
    public void personalCabinetAuthTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.personalAreaButtonClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.shouldCreateOrderButton("Оформить заказ");
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация по ссылке «Войти» на форме регистрации")
    public void registerAuthTest(){
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.personalAreaButtonClick();
        registerPage.registerLinkClick();
        registerPage.authLinkClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.shouldCreateOrderButton("Оформить заказ");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация по ссылке «Войти» на форме восстановления пароля")
    public void forgotPasswordAuthTest(){
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.personalAreaButtonClick();
        mainPage.forgotPasswordLinkClick();
        registerPage.authLinkClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.shouldCreateOrderButton("Оформить заказ");
    }
}
