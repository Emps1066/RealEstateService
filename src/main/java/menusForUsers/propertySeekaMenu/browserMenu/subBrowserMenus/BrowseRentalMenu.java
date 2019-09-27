package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import utilities.scanner.Scan;

public class BrowseRentalMenu {
    public void goToRentalMenu(SystemEngine engine, String displayable) {
        BrowseRentalMenuCallBack callBack = new BrowseRentalMenuCallBack();
        int option = Scan.askForOption(2, callBack.menu(displayable));
        if(option == 1)
        {
            goToRentalMenu(engine, displayable);
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
    }
}
