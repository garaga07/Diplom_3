package ru.praktikum.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.pages.MainPage;

@Feature("Конструктор")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Тесты на переход по разделам конструктора")
public class ConstructorTabsTest extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход в раздел Булки")
    public void bunSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSouseSection();
        mainPage.clickBunSection();
        mainPage.shouldBunSection();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход в раздел Соусы")
    public void souseSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSouseSection();
        mainPage.shouldSouseSection();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход в раздел Начинки")
    public void fillingSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingSection();
        mainPage.shouldFillingSection();
    }
}