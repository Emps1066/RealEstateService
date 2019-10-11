package menusForUsers.menuType;

import engine.SystemEngine;
import menusForUsers.propertyOwnerMenu.PropertyOwnerMenu;
import menusForUsers.propertySeekerMenu.PropertySeekerMenu;
import utilities.scanner.Scan;

public class ChooseCustomerInterfaceMenu {
    public void goToChooseCustomerInterfaceMenu(SystemEngine engine) {
        ChooseCustomerInterfaceMenuCallBack callBack = new ChooseCustomerInterfaceMenuCallBack();
        int option = Scan.askForOption(2, callBack.menu());
        if (option == 1) {
            PropertySeekerMenu propertySeekerMenu = new PropertySeekerMenu();
            propertySeekerMenu.goToMainMenu(engine);
        } else {
            PropertyOwnerMenu propertyOwnerMenu = new PropertyOwnerMenu();
            propertyOwnerMenu.goToPropertyOwnerMenu(engine);
        }
    }
}
