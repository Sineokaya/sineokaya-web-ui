package lesson7.features.testcases;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lesson7.enums.ContactSubMenuButtons;
import lesson7.pages.AllContactsPage;
import org.junit.jupiter.api.Test;
import lesson7.base.BaseUITest;
import lesson7.common.Configuration;
import lesson7.enums.NavigationBarTabs;
import lesson7.pages.LoginPage;
//Задание 7 Синеокая Марина

@Feature("New Contact")
@Severity(SeverityLevel.CRITICAL)
public class NewContactTest extends BaseUITest {

    @Test
    public void createNewContactPositiveTest() throws InterruptedException {
        AllContactsPage contactScreen = (AllContactsPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(ContactSubMenuButtons.CONTACTS_REQUEST);

        contactScreen
                .clickOnCreateNewContactButton()
                .enterLastName("Иванов")
                .enterFirstName("Иван")
                .selectExpenditure("1234")
                .enterPosition("инженер")
                .clickSubmit()
                .checkNewContactPop();
    }

}


