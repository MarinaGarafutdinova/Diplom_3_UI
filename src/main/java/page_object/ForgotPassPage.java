package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//страница восстановлениия пароля
public class ForgotPassPage {
    private static WebDriver driver;

    //костанты и локаторы

    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public ForgotPassPage(WebDriver driver) {
        ForgotPassPage.driver = driver;
    }

    @Step("Клик по ссылке Войти")
    public void clickEnterLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterLink));
        driver.findElement(enterLink).click();
    }

}

