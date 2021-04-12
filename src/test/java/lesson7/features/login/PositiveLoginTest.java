package lesson7.features.login;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import lesson7.base.BaseUITest;
import lesson7.pages.LoginPage;

import static lesson7.common.Configuration.BASE_URL;
import static lesson7.common.Configuration.STUDENT_LOGIN;
import static lesson7.common.Configuration.STUDENT_PASSWORD;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class PositiveLoginTest extends BaseUITest {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
            .enterLogin(STUDENT_LOGIN)
            .enterPassword(STUDENT_PASSWORD)
            .clickLoginButton()
            .checkUrl(BASE_URL);
    }
}
