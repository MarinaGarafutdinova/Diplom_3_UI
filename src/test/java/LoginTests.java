import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.ForgotPassPage;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;

public class LoginTests extends BaseUITest{
    private final String email;
    private final String password;

    public LoginTests() {
        this.password = "Paroll";
        this.email = "garafutdinova.m@yandex.ru";
    }

    @Test
    @DisplayName("Вход с главной страницы")
    @Description("Проверка входа через кнопку Войти в аккаунт на главной")
    public void successfulMainLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        mainPage.clickToLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.authorization(email,password);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());

    }

    @Test
    @DisplayName("Вход с через кнопку Личный кабинет")
    @Description("Проверка входа через кнопку Личный кабинет на главной")
    public void successfulProfileLoginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        mainPage.clickProfileButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.authorization(email,password);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());

    }

    @Test
    @DisplayName("Вход через Форму регистрации")
    @Description("Проверка входа через кнопку Войти в форме регистрации")
    public void successfulRegisterLoginTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.waitInvisibilityAnimation();
        registerPage.clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Вход через Форму восстановления пароля")
    @Description("Проверка входа через кнопку Войти в форме восстановления пароля")
    public void successfulForgotPassLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.clickForgotPasswordLink();
        ForgotPassPage forgotPassPage = new ForgotPassPage(driver);
        forgotPassPage.clickEnterLink();
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

}
