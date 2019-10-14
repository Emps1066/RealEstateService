package menusForUsers.employeeMenu.advertisedProperties;

import engine.SystemEngine;


import enums.Roles;
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

            String propertyId = Scan.askForString("Enter The PropertyId Of The Applications Or Offers:");
            if(engine.getPropertyManager().employeeIsAuthorized(engine.getUser().getId(), propertyId)) {

                Roles role = engine.getRolesManager().getRole(engine.getUser().getId());
                String display;
                if (role == Roles.SALES_ASSOCIATE) {

                    display = engine.getOfferManager().propertyOwnerOffersToListFormat(null, propertyId);
                    MyPropertyOffers menu = new MyPropertyOffers();
                    menu.goToMyPropertyOfferMenu(engine, display);
                } else if (role == Roles.PROPERTY_MANAGER) {

                    display = engine.getApplicationManager().propertyOwnerAppsToListFormat(null, propertyId);
                    MyPropertyApplications menu = new MyPropertyApplications();
                    menu.goToMyPropertyApplicationsMenu(engine, display);
                }
            } else {
                System.out.println("You Are Not Authorized");
                goToAdvertisedProperties(engine, displayable);
            }
        }
        else {
            MyEmployeeMenu employeeMenu = new MyEmployeeMenu();
            employeeMenu.goToMyEmployeeMenu(engine);
        }
    }

}
