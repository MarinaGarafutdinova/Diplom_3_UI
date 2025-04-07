package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//страница авторизации
public class LoginPage {
    private static WebDriver driver;

    //костанты и локаторы
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By recoveryPassLink = By.xpath(".//a[@href='/forgot-password']");
    public final By entranceTitle = By.xpath(".//h2[text()='Вход']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoLink = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    public static final String REAL_USER_EMAIL = "garafutdinova.m@yandex.ru";
    public static final String REAL_USER_PASS = "Paroll";

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }
    public void openLoginPage() {

        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Ввод e-mail" )
    public void setUserEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).click();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод пароля ")
    public void setUserPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("нажимаем кнопку Войти")
    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("нажимаем ссылку Восстановить пароль")
    public void clickForgotPasswordLink() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(recoveryPassLink));
        driver.findElement(recoveryPassLink).click();
    }

    @Step("Авторизация пользователя.")
    public void authorization(String email, String password) {
        setUserEmail(email);
        setUserPassword(password);
        clickLoginButton();
    }
    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogoLink() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(logoLink));
        driver.findElement(logoLink).click();
    }

}


