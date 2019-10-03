package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import systemManagers.OfferManager;
import utilities.scanner.Scan;

public class BrowseForSaleMenu {
    public void goToForSaleMenu(SystemEngine engine, String displayable) {
        BrowseForSaleMenuCallBack callBack = new BrowseForSaleMenuCallBack();
        int option = Scan.askForOption(2, callBack.menu(displayable));
        if(option == 1)
        {
            OfferManager offerManager = engine.getOfferManager();
            offerManager.sendOffer(engine.getUser(), engine.getPropertyManager());
            goToForSaleMenu(engine, displayable);
        }
        else {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
    }
}
