package menusForUsers.propertySeekaMenu.employeeMenu;

import account.Account;
import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.employeeMenu.advertisedProperties.AdvertisedProperties;
import menusForUsers.propertySeekaMenu.propertySeekaMenu.browserMenu.BrowseMenu;
import menusForUsers.propertySeekaMenu.propertySeekaMenu.myApplicationMenu.MyApplicationsMenu;
import menusForUsers.propertySeekaMenu.propertySeekaMenu.myOffersMenu.MyOffersMenu;
import utilities.scanner.Scan;

public class MyEmployeeMenu {
    public void goToMyEmployeeMenu(SystemEngine engine) {
        MyEmployeeMenuCallBack callBack = new MyEmployeeMenuCallBack();
        int option = Scan.askForOption(5, callBack.menu());
        if(option == 1) {
            AdvertisedProperties advertisedProperties = new AdvertisedProperties();
            advertisedProperties.goToAdvertisedProperties(engine, "");
        }
        else if(option == 2)
        {
            MyApplicationsMenu menu = new MyApplicationsMenu();
            menu.goToMyApplicationsMenu(engine, "");
        }
        else if(option == 3)
        {
            MyOffersMenu menu = new MyOffersMenu();
            menu.goToMyOffersMenu(engine, "");
        }
        else if(option == 4)
        {
            goToMyEmployeeMenu(engine);
        }
        else {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
