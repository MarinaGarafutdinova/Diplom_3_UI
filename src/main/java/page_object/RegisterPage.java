package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//страница регистрации
public class RegisterPage {

    private static WebDriver driver;

    //костанты и локаторы
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private final By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath(".//a[text()='Войти']");
    public final By errorTextForFalsePass = By.xpath(".//p[text()='Некорректный пароль']");


    public RegisterPage(WebDriver driver) {
        RegisterPage.driver = driver;
    }

    public void openRegisterPage() {

        driver.get(REGISTER_PAGE_URL);
    }

    @Step("Ввод имени" )
    public void setUserName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввод e-mail" )
    public void setUserEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод пароля ")
    public void setUserPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажимаем кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        driver.findElement(enterButton).click();
    }


}
