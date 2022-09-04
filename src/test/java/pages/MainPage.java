package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    // локатор кнопок в шапке
    private ElementsCollection headerButtons = $$(byClassName("AppHeader_header__linkText__3q_va"));

    // локатор кнопки Войти в аккаунт
    private SelenideElement loginButton = $(byClassName("button_button__33qZ0"));

    // локатор табов Булки, Соусы, Начинки
    private ElementsCollection tabs = $$(byClassName("tab_tab__1SPyG"));

    // локатор текущего таба
    private SelenideElement currentTab = $(byClassName("tab_tab_type_current__2BEPc"));

    @Step("Нажать Войти в аккаунт")
    public LoginPage clickLogInToAccountButton() {
        loginButton.click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    @Step("Нажать Личный кабинет")
    public LoginPage clickProfileButton() {
        headerButtons.get(2).click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    @Step("Нажать Личный кабинет")
    public ProfilePage clickPersonalAccountButton() {
        headerButtons.get(2).click();
        ProfilePage profilePage = Selenide.page(ProfilePage.class);
        profilePage.waitForLoadProfilePage();
        return profilePage;
    }

    @Step("Нажать Булки")
    public void clickBunsTab() {
        tabs.get(0).click();
    }

    @Step("Нажать Соусы")
    public void clickSaucesTab() {
        tabs.get(1).click();
    }

    @Step("Нажать Начинки")
    public void clickFillingsTab() {
        tabs.get(2).click();
    }

    @Step("Сравнить текст с ожидаемым")
    public void compareText(String expectedText) {
        currentTab.shouldHave(exactText(expectedText));
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoadMainPage() {
        $(byText("Соберите бургер")).shouldBe(visible);
    }
}
