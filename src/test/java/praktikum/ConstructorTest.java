package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static constant.Constant.*;
import static org.junit.Assert.assertEquals;

public class ConstructorTest {

    MainPage mainPage;

    @Before
    public void openMainPage() {
        mainPage = open(URL, MainPage.class);
    }

    @Test
    @DisplayName("Переход к разделу булки")
    public void checkOpenBunsTab() {
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        String currentTab = mainPage.findSelectedSection().getText();
        assertEquals(BUNS, currentTab);
    }

    @Test
    @DisplayName("Переход к разделу соусы")
    public void checkOpenSaucesTab() {
        mainPage.clickSaucesTab();
        String currentTab = mainPage.findSelectedSection().getText();
        assertEquals(SAUCES, currentTab);
    }

    @Test
    @DisplayName("Переход к разделу начинки")
    public void checkOpenFillingsTab() {
        mainPage.clickFillingsTab();
        String currentTab = mainPage.findSelectedSection().getText();
        assertEquals(FILLINGS, currentTab);
    }
}