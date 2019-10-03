package menusForUsers.propertySeekaMenu.myOffersMenu;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.PropertySeekerMenu;
import systemManagers.OfferManager;
import utilities.scanner.Scan;

public class MyOffersMenu {
    public void goToMyOffersMenu(SystemEngine engine, String displayable) {
        MyOffersMenuCallback callBack = new MyOffersMenuCallback();
        int option = Scan.askForOption(5, callBack.menu(displayable));
        if(option == 1)
        {
            String offerId = Scan.askForString("Enter Offer Id To Finalise:");

            OfferManager offerManager = engine.getOfferManager();
            offerManager.finaliseOffer(offerId, engine.getUser().getId(), engine.getPropertyManager());

            String display = offerManager.seekerAllOffersToListFormat(engine.getUser().getId());
            goToMyOffersMenu(engine, display);
        }
        else if(option == 2)
        {
            String offerId = Scan.askForString("Enter Offer Id To Withdraw:");

            OfferManager offerManager = engine.getOfferManager();
            offerManager.withdrawOffer(offerId, engine.getUser().getId());

            String display = offerManager.seekerAllOffersToListFormat(engine.getUser().getId());
            goToMyOffersMenu(engine, display);
        }
        else if(option == 3)
        {
            OfferManager offerManager = engine.getOfferManager();
            String display = offerManager.seekerPendingOffersToListFormat(engine.getUser().getId());
            goToMyOffersMenu(engine, display);
        }
        else if(option == 4)
        {
            OfferManager offerManager = engine.getOfferManager();
            String display = offerManager.seekerAcceptedOffersToListFormat(engine.getUser().getId());
            goToMyOffersMenu(engine, display);
        }
        else {
            PropertySeekerMenu menu = new PropertySeekerMenu();
            menu.goToMainMenu(engine);
        }
    }
}
