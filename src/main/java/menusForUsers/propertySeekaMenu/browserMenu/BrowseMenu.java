package menusForUsers.propertySeekaMenu.browserMenu;

import menusForUsers.propertySeekaMenu.PropertySeekaMenu;
import menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus.*;
import scanner.Scan;

public class BrowseMenu {
    public void goToBrowseMenu() {
        BrowseMenuCallBack callBack = new BrowseMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1) {
            BrowseRentalMenu menu = new BrowseRentalMenu();
            menu.goToRentalMenu();
        }
        else if(option == 2)
        {
            BrowseForSaleMenu menu = new BrowseForSaleMenu();
            menu.goToForSaleMenu();
        }
        else if(option == 3)
        {
            BrowseBySuburbMenu menu = new BrowseBySuburbMenu();
            menu.goToSuburbMenu();
        }
        else {
            PropertySeekaMenu menu = new PropertySeekaMenu();
            menu.goToMainMenu();
        }
    }
}
