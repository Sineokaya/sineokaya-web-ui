package lesson7.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static lesson7.common.Configuration.BASE_URL;
import static lesson7.common.Configuration.LOGIN_PATH;

public abstract class BaseUITest {
    //protected WebDriver driver;
    protected EventFiringWebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        RemoteWebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.setLogLevel(Level.INFO);
        // ----------------------------------------------------------------------

        // Обертка драйвера в EventFiringWebDriver, умеющего регистрировать кастомные листнеры
        driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new lesson7.listener.CustomLogger());
        // ----------------------------------------------------------------------

        // Остальная часть может быть использована без изменений
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_PATH);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}