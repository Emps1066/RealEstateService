package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import scanner.Scan;

public class BrowseRentalMenu {
    public void goToRentalMenu() {
        BrowseRentalMenuCallBack callBack = new BrowseRentalMenuCallBack();
        int option = Scan.askForOption(2, callBack.menu());
        if(option == 1)
        {
            goToRentalMenu();
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu();
        }
    }
}
