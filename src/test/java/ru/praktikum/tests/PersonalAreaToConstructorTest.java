package ru.praktikum.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.ProfilePage;


@Feature("Переход в конструктор")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Тесты на переход в конструктор из личного кабинета")
@RunWith(Parameterized.class)
public class PersonalAreaToConstructorTest extends TestBase {
    private By element;
    private String nameElement;
    public PersonalAreaToConstructorTest(By element,String nameElement) {
        this.element = element;
        this.nameElement = nameElement;
    }
    @Parameterized.Parameters(name = "Переход из личного кабинета в конструктор по клику на {1}")
    public static Object[][] getElementData() {
        return new Object[][]{
                {MainPage.getConstructorButton(),"Конструктор"},
                {MainPage.getLogoButton(),"логотип Stellar Burgers"},
        };
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void loginPersonalAreaTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.authAccountButtonClick();
        mainPage.emailSetValue("sergey123@yandex.ru");
        mainPage.passwordSetValue("Password");
        mainPage.authButtonClick();
        mainPage.personalAreaButtonClick();
        profilePage.shouldProfileText("В этом разделе вы можете изменить свои персональные данные");
        mainPage.navigateToConstructor(element);
        mainPage.shouldBurgerTitle("Соберите бургер");
    }
}