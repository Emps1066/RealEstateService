package menusForUsers.propertySeekaMenu;

import account.Account;
import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import menusForUsers.propertySeekaMenu.myApplicationMenu.MyApplicationsMenu;
import menusForUsers.propertySeekaMenu.myOffersMenu.MyOffersMenu;
import scanner.Scan;

public class PropertySeekaMenu
{
    public void goToMainMenu() {
        PropertySeekaMenuCallBack callBack = new PropertySeekaMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1) {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu();
        }
        else if(option == 2)
        {
            MyApplicationsMenu menu = new MyApplicationsMenu();
            menu.goToMyApplicationsMenu();
        }
        else if(option == 3)
        {
            MyOffersMenu menu = new MyOffersMenu();
            menu.goToMyOffersMenu();
        }
        else {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
