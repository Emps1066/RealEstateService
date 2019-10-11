package menusForUsers.propertyOwnerMenu;

import engine.SystemEngine;
import menusForUsers.propertyOwnerMenu.myApplicantsMenu.MyApplicantsMenu;
import menusForUsers.propertyOwnerMenu.myPropertiesMenu.MyPropertiesMenu;
import menusForUsers.propertyOwnerMenu.myOffersMenu.MyOffersMenu;
import systemManagers.ApplicationManager;
import systemManagers.OfferManager;
import systemManagers.PropertyManager;
import utilities.scanner.Scan;
import account.Account;

public class PropertyOwnerMenu {

    public void goToPropertyOwnerMenu(SystemEngine engine) {
        PropertyOwnerMenuCallBack callBack = new PropertyOwnerMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1)
        {
            PropertyManager propertyManager = engine.getPropertyManager();
            String display = propertyManager.myPropertiesToString(engine.getUser().getId());

            MyPropertiesMenu menu = new MyPropertiesMenu();
            menu.goToMyPropertiesMenu(engine, display);
        }
        else if(option == 2)
        {
            ApplicationManager applicationManager = engine.getApplicationManager();
            String display = applicationManager.propertyOwnerAppsToListFormat(engine.getUser().getId());

            MyApplicantsMenu menu = new MyApplicantsMenu();
            menu.goToMyApplicantsMenu(engine,display);
        }
        else if(option == 3)
        {
            OfferManager offerManager = engine.getOfferManager();
            String display = offerManager.propertyOwnerOffersToListFormat(engine.getUser().getId());

            MyOffersMenu menu = new MyOffersMenu();
            menu.goToMyOffersMenu(engine,display);
        }
        else {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
