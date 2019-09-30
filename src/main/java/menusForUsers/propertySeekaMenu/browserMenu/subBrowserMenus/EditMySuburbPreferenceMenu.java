package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;


import engine.SystemEngine;
import utilities.scanner.Scan;

public class EditMySuburbPreferenceMenu {
    public void goToEditMySuburbPreferenceMenu(SystemEngine engine, String displayable) {
        EditMySuburbPreferenceMenuCallBack callBack = new EditMySuburbPreferenceMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu(displayable));
        if(option == 1)
        {
            goToEditMySuburbPreferenceMenu(engine, "");
        }
        else if(option == 2)
        {
            goToEditMySuburbPreferenceMenu(engine, "");
        }
        else {
            BrowseBySuburbMenu menu = new BrowseBySuburbMenu();
            menu.goToSuburbMenu(engine, "");
        }
    }
}
