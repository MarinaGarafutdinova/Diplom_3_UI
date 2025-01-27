package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//страница личного кабинета
public class ProfilePage {
    private static WebDriver driver;


    //костанты и локаторы
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By profileAnimation = (By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']"));

    public ProfilePage(WebDriver driver) {
        ProfilePage.driver = driver;
    }

    public void openProfilePage(){

        driver.get(PROFILE_PAGE_URL);
    }

    @Step("Ожидание загрузки страницы полностью, анимация исчезнет.")
    public boolean waitInvisibilityAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(profileAnimation));
        return true;
    }

    @Step("Клик по кнопке Выйти")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();

    }


}


