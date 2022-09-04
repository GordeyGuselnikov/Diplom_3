package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    // локатор ссылки Войти
    private SelenideElement loginText = $(byClassName("Auth_link__1fOlj"));

    @Step("Нажать Войти")
    public LoginPage clickLogin() {
        loginText.click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoadForgotPasswordPage() {
        $(byText("Восстановление пароля")).shouldBe(visible);
    }
}
