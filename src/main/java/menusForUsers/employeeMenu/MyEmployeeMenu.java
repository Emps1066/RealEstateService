package menusForUsers.employeeMenu;

import account.Logger;
import engine.SystemEngine;
import menusForUsers.employeeMenu.advertisedProperties.AdvertisedProperties;
import menusForUsers.employeeMenu.underContractProperties.MyUnderContractProperties;
import menusForUsers.employeeMenu.underContractProperties.MyUnderContractPropertiesTwo;
import menusForUsers.propertySeekerMenu.myApplicationMenu.MyApplicationsMenu;
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
            MyUnderContractProperties myUnderContractProperties = new MyUnderContractProperties();
            myUnderContractProperties.goToUnderContractProperties(engine, "");

            MyUnderContractPropertiesTwo myUnderContractPropertiesTwo = new MyUnderContractPropertiesTwo();
            myUnderContractPropertiesTwo.goToUnderContractPropertiesTwo(engine, "");
        }
        else if(option == 4)
        {
            goToMyEmployeeMenu(engine);
        }
        else {
            Logger logOut = new Logger();
            logOut.logUserIn();
        }
    }
}
