package menusForUsers.employeeMenu.advertisedProperties.propertyApplications;

import engine.SystemEngine;
import menusForUsers.employeeMenu.advertisedProperties.AdvertisedProperties;
import utilities.scanner.Scan;

public class MyPropertyApplications {
    public void goToMyPropertyApplicationsMenu(SystemEngine engine, String displayable) {
        MyPropertyApplicationsCallBack callBack = new MyPropertyApplicationsCallBack();
        int option = Scan.askForOption(1, callBack.menu(displayable));
        if (option == 1) {
            AdvertisedProperties advertisedProperties = new AdvertisedProperties();
            advertisedProperties.goToAdvertisedProperties(engine, "");
        }
    }
}