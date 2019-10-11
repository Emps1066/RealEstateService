package engine;

import account.Logger;
import enums.UserType;
import menusForUsers.menuType.ChooseCustomerInterfaceMenu;

public class RunSystem {
    public void runSystem() {
        Logger logger = new Logger();
        SystemEngine engine = logger.logUserIn();

        if(engine.getUser().userType() == UserType.CUSTOMER) {
            ChooseCustomerInterfaceMenu chooseCustomerInterfaceMenu = new ChooseCustomerInterfaceMenu();
            chooseCustomerInterfaceMenu.goToChooseCustomerInterfaceMenu(engine);
        } else {

        }
    }
}
