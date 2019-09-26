package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import scanner.Scan;

public class BrowseBySuburbMenu {
    public void goToSuburbMenu() {
        BrowseBySuburbMenuCallBack callBack = new BrowseBySuburbMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1) {
            EditMySuburbPreferenceMenu menu = new EditMySuburbPreferenceMenu();
            menu.goToEditMySuburbPreferenceMenu();
        }
        else if(option == 2)
        {
            goToSuburbMenu();
        }
        else if(option == 3)
        {
            goToSuburbMenu();
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu();
        }
    }
}
