import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;

import static page_object.LoginPage.REAL_USER_EMAIL;
import static page_object.LoginPage.REAL_USER_PASS;

public class TransitionSiteTests extends BaseUITest{
    private final String email;
    private final String password;

    public TransitionSiteTests() {
        this.password = REAL_USER_PASS;
        this.email = REAL_USER_EMAIL;
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода при клике на кнопку Личный кабинет")
    public void transitionToProfileTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        boolean success = profilePage.openMainPage();
        Assert.assertTrue("Не удалось войти в профиль", success);
    }

    @Test
    @DisplayName("Выход из профиля")
    @Description("Проверка выхода из профиля ")
    public void exitTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickExitButton();
        Assert.assertTrue("Не удалось выйти из аккаунта",
                driver.findElement(loginPage.entranceTitle).isDisplayed());
    }

    @Test
    @DisplayName("Переход на главную через кнопку Конструктор")
    @Description("Проверка перехода при клике на кнопку Конструктор")
    public void transitionToMainWithConstructorButtonTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickConstructorButton();
        MainPage mainPage = new MainPage(driver);
        boolean success = mainPage.titleMainPageExist();
        Assert.assertTrue("Не удалось перейти на главную страницу",success);
    }

    @Test
    @DisplayName("Переход на главную через логотип")
    @Description("Проверка перехода при клике на логотип ")
    public void transitionToMainWithLogoTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickLogoLink();
        MainPage mainPage = new MainPage(driver);
        boolean success = mainPage.titleMainPageExist();
        Assert.assertTrue("Не удалось перейти на главную страницу",success);
    }

}
