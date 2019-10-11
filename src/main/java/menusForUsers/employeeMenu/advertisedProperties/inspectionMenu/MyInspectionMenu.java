package menusForUsers.employeeMenu.advertisedProperties.inspectionMenu;

import engine.SystemEngine;
import menusForUsers.employeeMenu.advertisedProperties.AdvertisedProperties;
import utilities.scanner.Scan;

public class MyInspectionMenu {
    public void goToInspectionMenu(SystemEngine engine, String displayable){
        MyInspectionMenuCallBack callBack = new MyInspectionMenuCallBack();
        int option = Scan.askForOption(3, callBack.menu(displayable));
        if(option == 1) {
            goToInspectionMenu(engine,"");

        }
        else if(option == 2) {
            goToInspectionMenu(engine,"");
        }
        else {
            AdvertisedProperties advertisedProperties = new AdvertisedProperties();
            advertisedProperties.goToAdvertisedProperties(engine,"");
        }
    }
}
