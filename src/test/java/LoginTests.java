import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.ForgotPassPage;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;

import static page_object.LoginPage.REAL_USER_EMAIL;
import static page_object.LoginPage.REAL_USER_PASS;

public class LoginTests extends BaseUITest{
    private final String email;
    private final String password;

    public LoginTests() {
        this.password = REAL_USER_PASS;
        this.email = REAL_USER_EMAIL;
    }

    @Test
    @DisplayName("Вход с главной страницы")
    @Description("Проверка входа через кнопку Войти в аккаунт на главной")
    public void successfulMainLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickToLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(email,password);
        mainPage.openMainPage();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());

    }

    @Test
    @DisplayName("Вход с через кнопку Личный кабинет")
    @Description("Проверка входа через кнопку Личный кабинет на главной")
    public void successfulProfileLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(email,password);
        mainPage.openMainPage();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());

    }

    @Test
    @DisplayName("Вход через Форму регистрации")
    @Description("Проверка входа через кнопку Войти в форме регистрации")
    public void successfulRegisterLoginTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Вход через Форму восстановления пароля")
    @Description("Проверка входа через кнопку Войти в форме восстановления пароля")
    public void successfulForgotPassLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickForgotPasswordLink();
        ForgotPassPage forgotPassPage = new ForgotPassPage(driver);
        forgotPassPage.clickEnterLink();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

}
