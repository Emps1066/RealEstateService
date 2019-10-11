package menusForUsers.propertySeekerMenu.browserMenu.subBrowserMenus;

import engine.SystemEngine;
import menusForUsers.propertySeekerMenu.browserMenu.BrowseMenu;
import systemManagers.ApplicationManager;
import systemManagers.OfferManager;
import utilities.scanner.Scan;

public class BrowseBySuburbMenu {
    public void goToSuburbMenu(SystemEngine engine, String displayable) {
        BrowseBySuburbMenuCallBack callBack = new BrowseBySuburbMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu(displayable));
        if(option == 1) {
            String display = engine.myPreferredSuburbsToListFormat();
            EditMySuburbPreferenceMenu menu = new EditMySuburbPreferenceMenu();
            menu.goToEditMySuburbPreferenceMenu(engine, display);
        }
        else if(option == 2)
        {
            ApplicationManager appManager = engine.getApplicationManager();
            appManager.sendApplication(engine.getUser(), engine.getPropertyManager());
            goToSuburbMenu(engine, displayable);
        }
        else if(option == 3)
        {
            OfferManager offerManager = engine.getOfferManager();
            offerManager.sendOffer(engine.getUser(), engine.getPropertyManager());
            goToSuburbMenu(engine, displayable);
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
    }
}
