package lesson7.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lesson7.base.BaseView;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class NewContactPage extends BaseView{


    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastNameTextInput;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstNameTextInput;


    @FindBy(xpath = "//span[contains(.,'Укажите организацию')]")
    private WebElement organisationDropDownSelect;
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    private WebElement organisationDropDownSelect2;
    @FindBy(xpath = "//div[4]/div/div[2]/div/a")
    private WebElement organisationDropDownSelect3;


    //@FindBy(name = "crm_contact[jobTitle]")
    @FindBy(xpath = "//div[2]/div[2]/div[2]/input")
    private WebElement positionTextInput;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement submitButton;

    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение фамилии")
    public NewContactPage enterLastName(String description) {
        lastNameTextInput.sendKeys(description);
        return this;
    }

    @Step("Добавление имени")
    public NewContactPage enterFirstName(String description) {
        firstNameTextInput.sendKeys(description);
        return this;
    }

    @Step("Добавление организации")
    public NewContactPage selectExpenditure(String description) throws InterruptedException {
        organisationDropDownSelect.click();
        organisationDropDownSelect2.sendKeys(description);
        sleep(5000);
        organisationDropDownSelect2.sendKeys(Keys.ENTER);
        sleep(5000);
        return this;
    }

    @Step("Добавление должности")
    public NewContactPage enterPosition(String description) {
        positionTextInput.sendKeys(description);
        return this;
    }

    @Step("Нажатие кнопки 'Сохранить и закрыть'")
    public AllContactsPage clickSubmit() {
        submitButton.click();
        return new AllContactsPage(driver);
    }
}

