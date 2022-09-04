package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    // локатор инпутов Email и Пароль
    private ElementsCollection inputs = $$(byClassName("input__textfield"));

    // локатор кнопки Войти
    private SelenideElement loginButton = $(byClassName("button_button__33qZ0"));

    // локатор ссылок Зарегистрироваться и Восстановить пароль
    private ElementsCollection linkText = $$(byClassName("Auth_link__1fOlj"));

    @Step("Ввести email")
    public void setEmail(String email) {
        inputs.get(0).setValue(email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        inputs.get(1).setValue(password);
    }

    @Step("Нажать Войти")
    public MainPage clickLogin() {
        loginButton.click();
        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.waitForLoadMainPage();
        return mainPage;
    }

    @Step("Нажать Зарегистрироваться")
    public RegisterPage clickRegister() {
        linkText.get(0).click();
        RegisterPage registerPage = Selenide.page(RegisterPage.class);
        registerPage.waitForLoadRegisterPage();
        return registerPage;
    }

    @Step("Нажать Восстановить пароль")
    public ForgotPasswordPage clickForgotPassword() {
        linkText.get(1).click();
        ForgotPasswordPage forgotPasswordPage = Selenide.page(ForgotPasswordPage.class);
        forgotPasswordPage.waitForLoadForgotPasswordPage();
        return forgotPasswordPage;
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoadLoginPage() {
        $(byText("Вход")).shouldBe(visible);
    }
}
