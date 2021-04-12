package lesson7.features.testcases;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lesson7.enums.ProjectSubMenuButtons;
import lesson7.pages.AllProjectsPage;
import org.junit.jupiter.api.Test;
import lesson7.base.BaseUITest;
import lesson7.common.Configuration;
import lesson7.enums.NavigationBarTabs;
import lesson7.pages.LoginPage;

//Задание 7 Синеокая Марина

@Feature("New Project")
@Severity(SeverityLevel.CRITICAL)
public class NewProjectTest extends BaseUITest {
    @Test
    public void createNewProjectPositiveTest() throws InterruptedException {
        AllProjectsPage projectScreen = (AllProjectsPage)  new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.PROJECTS)
                .clickSubMenuButton(ProjectSubMenuButtons.MY_PROJECTS_REQUEST);

        projectScreen
                .clickOnCreateNewProjectButton()
                //.enterName("Test")
                //чтобы тест не падал, генерирую случайное имя
                .enterName(getRandomWord(5))
                .enterOrganization("123test")
                .enterContact("John Smith")
                .enterDept("Research & Development")
                .enterHead("Карпов Руслан")
                .enterBoss("Андреев Сергей")
                .enterAdmin("Исаева Анастасия")
                .enterManager("Антонов Дмитрий")
                .clickSubmit()
                .checkNewProjectPopUp();
    }

    //случайное имя
    String getRandomWord(int length) {
        String r = "";
        for(int i = 0; i < length; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }
}



