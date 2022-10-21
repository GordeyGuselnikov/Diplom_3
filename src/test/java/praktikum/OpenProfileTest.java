package praktikum;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static constant.Constant.*;

public class OpenProfileTest {

    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Before
    public void openMainPage() {
        mainPage = open(URL, MainPage.class);
    }

    @After
    public void logOut() {
        profilePage = mainPage.clickPersonalAccountButton();
        profilePage.clickLogOut();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(LOGIN_URL, currentUrl);
    }

    @Test
    @DisplayName("Переход в личный кабинет (профиль)")
    public void checkLogInUsingLogInToAccountButton() {
        loginPage = mainPage.clickLogInToAccountButton();
        loginPage.setEmail(DEFAULT_EMAIL);
        loginPage.setPassword(DEFAULT_PASSWORD);
        mainPage = loginPage.clickLogin();
        mainPage.clickPersonalAccountButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(ACCOUNT_PROFILE_URL, currentUrl);
    }
}
