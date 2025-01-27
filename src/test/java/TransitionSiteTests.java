import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;

public class TransitionSiteTests extends BaseUITest{
    private final String email;
    private final String password;

    public TransitionSiteTests() {
        this.password = "Paroll";
        this.email = "garafutdinova.m@yandex.ru";
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода при клике на кнопку Личный кабинет")
    public void transitionToProfileTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfilePage();
        boolean success = profilePage.waitInvisibilityAnimation();
        Assert.assertTrue(success);
    }

    @Test
    @DisplayName("Выход из профиля")
    @Description("Проверка выхода из профиля ")
    public void exitTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.authorization(email,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.waitInvisibilityAnimation();
        mainPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openProfilePage();
        profilePage.waitInvisibilityAnimation();
        profilePage.clickExitButton();
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        Assert.assertTrue("Не удалось выйти из аккаунта",
                driver.findElement(loginPage.entranceTitle).isDisplayed());
    }

    @Test
    @DisplayName("Переход на главную через кнопку Конструктор")
    @Description("Проверка перехода при клике на кнопку Конструктор")
    public void transitionToMainWithConstructorButtonTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.clickConstructorButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean success = mainPage.titleMainPageExist();
        Assert.assertTrue(success);
    }

    @Test
    @DisplayName("Переход на главную через логотип")
    @Description("Проверка перехода при клике на логотип ")
    public void transitionToMainWithLogoTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitInvisibilityAnimation();
        loginPage.clickLogoLink();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        boolean success = mainPage.titleMainPageExist();
        Assert.assertTrue(success);
    }

}
