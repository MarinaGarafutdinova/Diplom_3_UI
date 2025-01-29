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
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    public static final String PROFILE_PAGE_URL ="https://stellarburgers.nomoreparties.site/account/profile";
    public ProfilePage(WebDriver driver) {
        ProfilePage.driver = driver;
    }

    public boolean openMainPage() {
        driver.get(PROFILE_PAGE_URL);
        return true;
    }

    @Step("Клик по кнопке Выйти")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();

    }


}


