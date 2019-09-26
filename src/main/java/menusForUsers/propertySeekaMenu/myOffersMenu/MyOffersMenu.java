package menusForUsers.propertySeekaMenu.myOffersMenu;

import menusForUsers.propertySeekaMenu.PropertySeekaMenu;
import scanner.Scan;

public class MyOffersMenu {
    public void goToMyOffersMenu() {
        MyOffersMenuCallback callBack = new MyOffersMenuCallback();
        int option = Scan.askForOption(3, callBack.menu());
        if(option == 1)
        {
            goToMyOffersMenu();
        }
        else if(option == 2)
        {
            goToMyOffersMenu();
        }
        else {
            PropertySeekaMenu menu = new PropertySeekaMenu();
            menu.goToMainMenu();
        }
    }
}
