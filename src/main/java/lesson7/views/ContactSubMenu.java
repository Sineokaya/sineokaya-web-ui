package lesson7.views;
import lesson7.enums.ContactSubMenuButtons;
import lesson7.pages.AllContactsPage;
import org.openqa.selenium.WebDriver;
import lesson7.base.BaseView;
import lesson7.base.SubMenu;
import lesson7.base.SubMenuButtons;

public class ContactSubMenu extends SubMenu{
    public ContactSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ContactSubMenuButtons) {
            switch ((ContactSubMenuButtons) buttons) {
                case CONTACTS_REQUEST:
                driver.findElement(((ContactSubMenuButtons) buttons).getBy()).click();
                return new AllContactsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}

