package ru.praktikum.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.ProfilePage;

@Feature("Личный кабинет")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Тесты на личный кабинет")
public class ProfileTest extends TestBase {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Вход в личный кабинет ")
    public void loginPersonalAreaTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.authAccountButtonClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.personalAreaButtonClick();
        profilePage.shouldProfileText("В этом разделе вы можете изменить свои персональные данные");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Выход из личного кабинета")
    public void logoutPersonalAreaTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.authAccountButtonClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.personalAreaButtonClick();
        profilePage.logoutButtonClick();
        mainPage.shouldAuthText("Вход");
    }
}