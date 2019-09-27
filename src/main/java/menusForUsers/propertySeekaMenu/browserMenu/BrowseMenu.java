package menusForUsers.propertySeekaMenu.browserMenu;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.PropertySeekaMenu;
import menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus.*;
import utilities.scanner.Scan;

public class BrowseMenu {
    public void goToBrowseMenu(SystemEngine engine) {
        BrowseMenuCallBack callBack = new BrowseMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1) {
            BrowseRentalMenu menu = new BrowseRentalMenu();
            menu.goToRentalMenu(engine, "");
        }
        else if(option == 2)
        {
            BrowseForSaleMenu menu = new BrowseForSaleMenu();
            menu.goToForSaleMenu(engine, "");
        }
        else if(option == 3)
        {
            BrowseBySuburbMenu menu = new BrowseBySuburbMenu();
            menu.goToSuburbMenu(engine, "");
        }
        else {
            PropertySeekaMenu menu = new PropertySeekaMenu();
            menu.goToMainMenu(engine);
        }
    }
}
