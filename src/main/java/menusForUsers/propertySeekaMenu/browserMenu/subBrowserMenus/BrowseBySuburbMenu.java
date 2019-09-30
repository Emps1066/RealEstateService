package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import utilities.scanner.Scan;

public class BrowseBySuburbMenu {
    public void goToSuburbMenu(SystemEngine engine, String displayable) {
        BrowseBySuburbMenuCallBack callBack = new BrowseBySuburbMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu(displayable));
        if(option == 1) {
            EditMySuburbPreferenceMenu menu = new EditMySuburbPreferenceMenu();
            menu.goToEditMySuburbPreferenceMenu(engine, "");
        }
        else if(option == 2)
        {
            goToSuburbMenu(engine, displayable);
        }
        else if(option == 3)
        {
            goToSuburbMenu(engine, displayable);
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
    }
}
