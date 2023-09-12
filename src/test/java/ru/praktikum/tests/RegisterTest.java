package ru.praktikum.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.RegisterPage;

@Feature("Регистрация пользователя")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Тесты на регистрацию пользователя")
public class RegisterTest extends TestBase {
    Faker faker = new Faker();
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Успешная регистрация пользователя")
    public void successfulRegistrationTest(){
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.personalAreaButtonClick();
        registerPage.registerLinkClick();
        registerPage.nameSetValue(faker.name().fullName());
        registerPage.emailSetValue(faker.internet().emailAddress());
        registerPage.passwordSetValue(faker.internet().password());
        registerPage.buttonRegisterClick();
        registerPage.shouldAuthText("Вход");
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Ввод некорректного пароля при регистрации")
    public void invalidPasswordRegistrationTest(){
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.personalAreaButtonClick();
        registerPage.registerLinkClick();
        registerPage.nameSetValue(faker.name().fullName());
        registerPage.emailSetValue(faker.internet().emailAddress());
        registerPage.passwordSetValue("pass");
        registerPage.buttonRegisterClick();
        registerPage.checkIncorrectPasswordError("Некорректный пароль");
    }
}
