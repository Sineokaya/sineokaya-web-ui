package lesson3_tokyo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;
public class Login {
    private static final String LOGIN_PAGE_URL = "https://www.tokyo-city.ru/";
    private static final String STUDENT_LOGIN = "grvik5@mail.ru";
    private static final String STUDENT_PASSWORD = "Qwerty123456";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        login();
        sleep(5000);
        driver.quit();

    }
    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.cssSelector(".user-block:nth-child(3) > .user-block__login")).click();

        WebElement loginTextInput = driver.findElement(By.xpath("//div[6]/div[2]/form/input"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.xpath("//input[@name='su_pass']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        driver.findElement(By.xpath("//form[@id='loginFrom']/input[3]")).click();

    }
}