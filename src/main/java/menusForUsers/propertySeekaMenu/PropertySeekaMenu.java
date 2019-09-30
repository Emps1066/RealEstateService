package menusForUsers.propertySeekaMenu;

import account.Account;
import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import menusForUsers.propertySeekaMenu.myApplicationMenu.MyApplicationsMenu;
import menusForUsers.propertySeekaMenu.myOffersMenu.MyOffersMenu;
import utilities.scanner.Scan;

public class PropertySeekaMenu
{
    public void goToMainMenu(SystemEngine engine) {
        PropertySeekaMenuCallBack callBack = new PropertySeekaMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1) {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
        else if(option == 2)
        {
            MyApplicationsMenu menu = new MyApplicationsMenu();
            menu.goToMyApplicationsMenu(engine, "");
        }
        else if(option == 3)
        {
            MyOffersMenu menu = new MyOffersMenu();
            menu.goToMyOffersMenu(engine, "");
        }
        else {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
