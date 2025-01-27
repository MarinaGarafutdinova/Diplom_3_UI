package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


//главная страница
public class MainPage {
    public static WebDriver driver;

    // константы и локаторы
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final By toLoginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By profileButton = By.xpath(".//a[@href='/account']/p[text()='Личный Кабинет']");
    private final By bunsTab = By.xpath("//span[text()='Булки']");
    private final By saucesTab = By.xpath("//span[text()='Соусы']");
    private final By fillingsTab = By.xpath("//span[text()='Начинки']");
    public final By bunImg = By.xpath(".//p[text()='Краторная булка N-200i']");
    public final By sauceImg = By.xpath(".//p[text()='Соус фирменный Space Sauce']");
    public final By fillingImg = By.xpath(".//p[text()='Говяжий метеорит (отбивная)']");
    public final By titleMainPage = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");
    private final By mainAnimation = By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']");


    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    // методы
    @Step("Клик по кнопке Войти в аккаунт")
    public void clickToLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(toLoginButton));
        driver.findElement(toLoginButton).click();

    }

    @Step("Клик по кнопке Личный Кабинет")
    public void clickProfileButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();
    }


    @Step("Клик по вкладке Булки")
    public void clickBunsTab() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(bunsTab));
        driver.findElement(bunsTab).click();

    }

    @Step("Клик по вкладке Соусы")
    public void clickSaucesTab() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
    }

    @Step("Клик по вкладке Начинки")
    public void clickFillingTab() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
    }

    @Step("Появлениие заголовка Соберите бургер")
    public boolean titleMainPageExist() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(titleMainPage));
        return driver.findElement(titleMainPage).isDisplayed();
    }

    @Step("Ожидание загрузки страницы полностью, анимация исчезнет.")
    public void waitInvisibilityAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(mainAnimation));

    }
}



