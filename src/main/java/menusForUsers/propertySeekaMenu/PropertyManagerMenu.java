package menusForUsers.propertyManagerMenu;

import account.Account;
import engine.SystemEngine;
import menusForUsers.propertyManagerMenu.browserMenu.BrowseMenu;
import menusForUsers.propertyManagerMenu.myApplicationMenu.MyApplicationsMenu;
import menusForUsers.propertyManagerMenu.myOffersMenu.MyOffersMenu;
import utilities.scanner.Scan;

public class PropertyManagerMenu
{
    public void goToMainMenu(SystemEngine engine) {
        PropertyManagerMenuCallBack callBack = new PropertyManagerMenuCallBack();
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
