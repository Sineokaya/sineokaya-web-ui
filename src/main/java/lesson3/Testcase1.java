package lesson3;
//Задание 3 Синеокая Марина
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Testcase1 {
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
        driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/ul/li[4]/a/span")).click();
        driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[2]/div/div/a")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys("test");

        driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("123test");
        sleep(5000);
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
        sleep(5000);
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/a")).click();
        sleep(5000);
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/a")).sendKeys(Keys.ENTER);
        sleep(5000);

        driver.findElement(By.xpath("//div[5]/div[2]/div/select")).click();
        //sleep(5000);
        driver.findElement(By.xpath("//div[5]/div[2]/div/select")).sendKeys("Research & Development");
        driver.findElement(By.xpath("//div[5]/div[2]/div/select")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[6]/div[2]/div/select")).click();
        //sleep(5000);
        driver.findElement(By.xpath("//div[6]/div[2]/div/select")).sendKeys("Карпов Руслан");
        driver.findElement(By.xpath("//div[6]/div[2]/div/select")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[7]/div[2]/div/select")).click();
        //sleep(5000);
        driver.findElement(By.xpath("//div[7]/div[2]/div/select")).sendKeys("Андреев Сергей");
        driver.findElement(By.xpath("//div[7]/div[2]/div/select")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[8]/div[2]/div/select")).click();
        //sleep(5000);
        driver.findElement(By.xpath("//div[8]/div[2]/div/select")).sendKeys("Исаева Анастасия");
        driver.findElement(By.xpath("//div[8]/div[2]/div/select")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[9]/div[2]/div/select")).click();
        //sleep(5000);
        driver.findElement(By.xpath("//div[9]/div[2]/div/select")).sendKeys("Антонов Дмитрий");
        driver.findElement(By.xpath("//div[9]/div[2]/div/select")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[4]/button")).click();
        sleep(5000);
        driver.findElement(By.xpath("//li/a")).click();
        sleep(5000);

        driver.findElement(By.cssSelector("#user-menu > .dropdown-toggle")).click();
        //sleep(5000);
        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        //хотела сделать assert, не получилось
        //String actualString = driver.findElement(By.cssSelector("input[id='prependedInput']")).getText();
        //Assert.assertTrue(actualString.equals("Applanatest"));

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}