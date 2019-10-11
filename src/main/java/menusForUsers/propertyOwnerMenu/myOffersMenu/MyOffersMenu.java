package menusForUsers.propertyOwnerMenu.myOffersMenu;

import menusForUsers.propertyOwnerMenu.PropertyOwnerMenu;
import systemManagers.OfferManager;
import utilities.scanner.Scan;
import engine.SystemEngine;


public class MyOffersMenu {

    public void goToMyOffersMenu(SystemEngine engine, String displayable) {
        MyOffersMenuCallBack callBack = new MyOffersMenuCallBack();
        int option = Scan.askForOption(3, callBack.menu(displayable));

        OfferManager offerManager = engine.getOfferManager();
        if(option == 1) {
            String offerId = Scan.askForString("Enter The ID Of The Offer To Accept:");

            offerManager.acceptOffer(offerId, engine.getUser().getId(), engine.getPropertyManager());
        }
        else if(option == 2)
        {
            String offerId = Scan.askForString("Enter The ID Of The Offer To Reject:");

            offerManager.rejectOffer(offerId, engine.getUser().getId());
        }
        else {
            PropertyOwnerMenu menu = new PropertyOwnerMenu ();
            menu.goToPropertyOwnerMenu(engine);
        }

        String display = offerManager.propertyOwnerOffersToListFormat(engine.getUser().getId());
        goToMyOffersMenu(engine,display);
    }
}
