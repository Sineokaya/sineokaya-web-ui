package lesson3;
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
public class Testcase2 {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
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
        driver.findElement(By.xpath("//span[contains(.,'Контрагенты')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]")).click();
        driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//div/div/div[2]/input")).click();
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Иванов");
        driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Иван");
        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();

        driver.findElement(By.cssSelector(".select2-input")).sendKeys("1234");
        sleep(5000);
        driver.findElement(By.cssSelector(".select2-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[2]/div[2]/div[2]/input")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("инженер");
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        sleep(5000);
        driver.findElement(By.cssSelector("#user-menu > .dropdown-toggle")).click();
        sleep(5000);
        driver.findElement(By.cssSelector(".last > .no-hash")).click();
        sleep(5000);
        driver.quit();

    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}
