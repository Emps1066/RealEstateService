package menusForUsers.employeeMenu.advertisedProperties.propertyOffers;

import engine.SystemEngine;
import menusForUsers.employeeMenu.advertisedProperties.AdvertisedProperties;
import utilities.scanner.Scan;

public class MyPropertyOffers {
    public void goToMyPropertyOfferMenu(SystemEngine engine, String displayable) {
        MyPropertyOffersCallBack callBack = new MyPropertyOffersCallBack();
        int option = Scan.askForOption(1, callBack.menu(displayable));
        if (option == 1) {
            AdvertisedProperties advertisedProperties = new AdvertisedProperties();
            advertisedProperties.goToAdvertisedProperties(engine, "");
        }
    }
}
