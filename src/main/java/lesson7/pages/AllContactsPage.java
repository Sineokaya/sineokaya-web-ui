package lesson7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import lesson7.base.BaseView;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AllContactsPage extends BaseView {
    @FindBy(linkText = "Создать контактное лицо")
    private WebElement createNewContactButton;

    public AllContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие кнопки 'создать новый контакт'")
    public NewContactPage clickOnCreateNewContactButton() {
        createNewContactButton.click();
        return new NewContactPage(driver);
    }

    @Step("Проверка создания и сохранения нового контактного лица")
    public AllContactsPage checkNewContactPop(){
        String message2 = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message2.contains("Контактное лицо сохранено"));
        return this;
    }

}

