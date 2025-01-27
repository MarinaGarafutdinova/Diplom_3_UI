import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.MainPage;
import page_object.RegisterPage;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class RegistrationTests extends BaseUITest {

    @Test
    @DisplayName("Регистрация пользователя с валидным паролями")
    @Description("Проверка регистрации пользователя с  паролем от 6 символов")
    public void successfulRegistrationTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.setUserName("MARI");
        registerPage.setUserEmail("Mari@yandrx.ru");
        registerPage.setUserPassword(randomAlphanumeric(6, 20));
        registerPage.clickRegisterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue("Авторизация не успешная",
                driver.findElement(mainPage.titleMainPage).isDisplayed());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Проверка регистрации пользователя с  паролем менее 6 символов")
    public void unsuccessfulRegistrationTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.setUserName("MARI");
        registerPage.setUserEmail("Mari@yandrx.ru");
        registerPage.setUserPassword(randomAlphanumeric(4, 5));
        registerPage.clickRegisterButton();
        Assert.assertTrue("Текст об ошибке отсутствует",
                driver.findElement(registerPage.errorTextForFalsePass).isDisplayed());

    }

}

