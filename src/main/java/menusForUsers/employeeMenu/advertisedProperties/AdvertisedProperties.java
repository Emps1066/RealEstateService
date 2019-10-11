package menusForUsers.employeeMenu.advertisedProperties;

import engine.SystemEngine;


import menusForUsers.employeeMenu.MyEmployeeMenu;
import menusForUsers.employeeMenu.advertisedProperties.inspectionMenu.MyInspectionMenu;
import menusForUsers.employeeMenu.advertisedProperties.propertyApplications.MyPropertyApplications;
import menusForUsers.employeeMenu.advertisedProperties.propertyOffers.MyPropertyOffers;
import utilities.scanner.Scan;

public class AdvertisedProperties {
    public void goToAdvertisedProperties(SystemEngine engine, String displayable){
        AdvertisedPropertiesCallBack callBack = new AdvertisedPropertiesCallBack();
        int option = Scan.askForOption(3, callBack.menu(displayable));
        if(option == 1) {
            MyInspectionMenu menu = new MyInspectionMenu();
            menu.goToInspectionMenu(engine,"");
        }
        else if(option == 2) {
            MyPropertyApplications menu = new MyPropertyApplications();
            menu.goToMyPropertyApplicationsMenu(engine, "");

            MyPropertyOffers menu1 = new MyPropertyOffers();
            menu1.goToMyPropertyOfferMenu(engine, "");
        }
        else {
            MyEmployeeMenu employeeMenu = new MyEmployeeMenu();
            employeeMenu.goToMyEmployeeMenu(engine);
        }
    }

}
