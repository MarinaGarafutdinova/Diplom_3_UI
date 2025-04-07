import browser.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.time.Duration;

public class BaseUITest {

    protected WebDriver driver;

    @Before
    public void startUp() throws IOException {
        Browser browser = new Browser();
        driver = browser.initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}