package lesson7.views;
import lesson7.enums.ProjectSubMenuButtons;
import lesson7.pages.AllProjectsPage;
import org.openqa.selenium.WebDriver;
import lesson7.base.BaseView;
import lesson7.base.SubMenu;
import lesson7.base.SubMenuButtons;

public class ProjectSubMenu extends SubMenu{
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ProjectSubMenuButtons) {
            switch ((ProjectSubMenuButtons) buttons) {
                case MY_PROJECTS_REQUEST:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new AllProjectsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}

