package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import scanner.Scan;

public class BrowseForSaleMenu {
    public void goToForSaleMenu() {
        BrowseForSaleMenuCallBack callBack = new BrowseForSaleMenuCallBack();
        int option = Scan.askForOption(2, callBack.menu());
        if(option == 1)
        {
            goToForSaleMenu();
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu();
        }
    }
}
