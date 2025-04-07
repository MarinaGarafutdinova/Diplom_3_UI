import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import page_object.LoginPage;
import page_object.RegisterPage;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class RegistrationTests extends BaseUITest {
    private final String name;
    private final String email;

    public RegistrationTests() {
        this.name = "Mari"+ RandomStringUtils.randomAlphabetic(3);
        this.email = "Mari"+ RandomStringUtils.randomAlphabetic(3)+ "@yandex.ru";
    }

    @Test
    @DisplayName("Регистрация пользователя с валидным паролями")
    @Description("Проверка регистрации пользователя с  паролем от 6 символов")
    public void successfulRegistrationTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.setUserName(name);
        registerPage.setUserEmail(email);
        registerPage.setUserPassword(randomAlphanumeric(6, 20));
        registerPage.clickRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(loginPage.entranceTitle).isDisplayed());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Проверка регистрации пользователя с  паролем менее 6 символов")
    public void unsuccessfulRegistrationTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.setUserName(name);
        registerPage.setUserEmail(email);
        registerPage.setUserPassword(randomAlphanumeric(4, 5));
        registerPage.clickRegisterButton();
        Assert.assertTrue("Текст об ошибке отсутствует",
                driver.findElement(registerPage.errorTextForFalsePass).isDisplayed());

    }

}

