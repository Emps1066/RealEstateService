package menusForUsers.propertySeekerMenu.browserMenu;

import engine.SystemEngine;
import enums.PropertyListType;
import menusForUsers.propertySeekerMenu.PropertySeekerMenu;
import menusForUsers.propertySeekerMenu.browserMenu.subBrowserMenus.BrowseBySuburbMenu;
import menusForUsers.propertySeekerMenu.browserMenu.subBrowserMenus.BrowseForSaleMenu;
import menusForUsers.propertySeekerMenu.browserMenu.subBrowserMenus.BrowseRentalMenu;
import utilities.scanner.Scan;

public class BrowseMenu {
    public void goToBrowseMenu(SystemEngine engine) {
        BrowseMenuCallBack callBack = new BrowseMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1) {
            String displayable = engine.getPropertyManager().listedPropertiesToString(PropertyListType.RENTAL);
            BrowseRentalMenu menu = new BrowseRentalMenu();
            menu.goToRentalMenu(engine, displayable);
        }
        else if(option == 2)
        {
            String displayable = engine.getPropertyManager().listedPropertiesToString(PropertyListType.FOR_SALE);
            BrowseForSaleMenu menu = new BrowseForSaleMenu();
            menu.goToForSaleMenu(engine, displayable);
        }
        else if(option == 3)
        {
            String displayable = engine.getPropertyManager().preferencePropertiesToString(engine.getMyPreferredSuburbs());
            BrowseBySuburbMenu menu = new BrowseBySuburbMenu();
            menu.goToSuburbMenu(engine, displayable);
        }
        else {
            PropertySeekerMenu menu = new PropertySeekerMenu();
            menu.goToMainMenu(engine);
        }
    }
}
