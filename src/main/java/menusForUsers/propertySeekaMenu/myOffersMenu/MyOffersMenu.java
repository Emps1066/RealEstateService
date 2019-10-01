package menusForUsers.propertySeekaMenu.myOffersMenu;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.PropertySeekaMenu;
import utilities.scanner.Scan;

public class MyOffersMenu {
    public void goToMyOffersMenu(SystemEngine engine, String displayable) {
        System.out.println(displayable);
        MyOffersMenuCallback callBack = new MyOffersMenuCallback();
        /*int option = Scan.askForOption(3, callBack.menu());*/
        int option = Scan.askForOption(3,callBack.menu(displayable));
        if(option == 1)
        {
            goToMyOffersMenu(engine, displayable);
        }
        else if(option == 2)
        {
            goToMyOffersMenu(engine, "");
        }
        else if(option == 3)
        {
            goToMyOffersMenu(engine, "");
        }
        else if(option == 4)
        {
            goToMyOffersMenu(engine, "");
        }
        else {
            PropertySeekaMenu menu = new PropertySeekaMenu();
            menu.goToMainMenu(engine);
        }
    }
}
