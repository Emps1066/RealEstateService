package menusForUsers.propertySeekerMenu.browserMenu.subBrowserMenus;

import engine.SystemEngine;
import menusForUsers.propertySeekerMenu.browserMenu.BrowseMenu;
import systemManagers.ApplicationManager;
import utilities.scanner.Scan;

public class BrowseRentalMenu {
    public void goToRentalMenu(SystemEngine engine, String displayable) {
        BrowseRentalMenuCallBack callBack = new BrowseRentalMenuCallBack();
        int option = Scan.askForOption(2, callBack.menu(displayable));
        if(option == 1)
        {
            ApplicationManager appManager = engine.getApplicationManager();
            appManager.sendApplication(engine.getUser(), engine.getPropertyManager());
            goToRentalMenu(engine, displayable);
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
    }
}
