import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.MainPage;

public class TransitionIngredientTabTests extends BaseUITest {

    @Test
    @DisplayName("Переключение на вкладку Соусы")
    @Description("Проверка перехода в раздел Соусы кликом по вкладке")
    public void goToSaucesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSaucesTab();
        Assert.assertTrue("Вкладка не отображается",
                mainPage.isSaucesTabSelected());

    }

    @Test
    @DisplayName("Переключение на вкладку Булки")
    @Description("Проверка перехода в раздел Булки кликом по вкладке")
    public void goToBunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        Assert.assertTrue("Вкладка не отображается",
                mainPage.isBunsTabSelected());

    }
    @Test
    @DisplayName("Переключение на вкладку Начинки")
    @Description("Проверка перехода в раздел Начинки кликом по вкладке")
    public void goToFillingTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingTab();
        Assert.assertTrue("Вкладка не отображается",
                mainPage.isFillingsTabSelected());

    }
}
