package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    // локатор ссылки Войти
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement loginText;

    @FindBy(how = How.XPATH, xpath = "//div[@id='root']/div/main/div/h2")
    private SelenideElement passwordRecoveryText;

    @Step("Нажать Войти")
    public LoginPage clickLogin() {
        loginText.click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoadForgotPasswordPage() {
        passwordRecoveryText.shouldBe(visible);
    }
}
