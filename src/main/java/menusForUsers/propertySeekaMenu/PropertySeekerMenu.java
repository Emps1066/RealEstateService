package menusForUsers.propertySeekaMenu;

import account.Account;
import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.browserMenu.BrowseMenu;
import menusForUsers.propertySeekaMenu.myApplicationMenu.MyApplicationsMenu;
import menusForUsers.propertySeekaMenu.myOffersMenu.MyOffersMenu;
import systemManagers.ApplicationManager;
import systemManagers.OfferManager;
import utilities.scanner.Scan;

public class PropertySeekerMenu
{
    public void goToMainMenu(SystemEngine engine) {
        PropertySeekerMenuCallBack callBack = new PropertySeekerMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());

        if(option == 1) {
            BrowseMenu menu = new BrowseMenu();
            menu.goToBrowseMenu(engine);
        }
        else if(option == 2)
        {
            MyApplicationsMenu menu = new MyApplicationsMenu();
            ApplicationManager applicationManager = engine.getApplicationManager();
            String display = applicationManager.propertySeekerAllAppsToListFormat(engine.getUser().getId());
            menu.goToMyApplicationsMenu(engine, display);
        }
        else if(option == 3)
        {
            MyOffersMenu menu = new MyOffersMenu();
            OfferManager offerManager = engine.getOfferManager();
            String display = offerManager.propertySeekerAllOffersToListFormat(engine.getUser().getId());
            menu.goToMyOffersMenu(engine, display);
        }
        else {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
