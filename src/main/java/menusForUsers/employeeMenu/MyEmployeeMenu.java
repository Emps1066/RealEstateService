package menusForUsers.employeeMenu;

import account.Logger;
import engine.SystemEngine;
import enums.Roles;
import menusForUsers.employeeMenu.advertisedProperties.AdvertisedProperties;
import menusForUsers.employeeMenu.unadvertisedProperties.MyUnadvertisedProperties;
import menusForUsers.employeeMenu.underContractProperties.MyUnderContractPropertiesForSale;
import menusForUsers.employeeMenu.underContractProperties.MyUnderContractPropertiesRental;
import utilities.scanner.Scan;

public class MyEmployeeMenu {
    public void goToMyEmployeeMenu(SystemEngine engine) {
        MyEmployeeMenuCallBack callBack = new MyEmployeeMenuCallBack();
        int option = Scan.askForOption(5, callBack.menu());
        if(option == 1) {
            String display = engine.getPropertyManager().employeesAdvertisedProperties(engine.getUser().getId());
            AdvertisedProperties advertisedProperties = new AdvertisedProperties();
            advertisedProperties.goToAdvertisedProperties(engine, display);
        }
        else if(option == 2)
        {
            String display = engine.getPropertyManager().employeesUnAdvertisedProperties(engine.getUser().getId());
            MyUnadvertisedProperties menu = new MyUnadvertisedProperties();
            menu.goToUnadvertisedProperties(engine, display);
        }
        else if(option == 3)
        {
            Roles role = engine.getRolesManager().getRole(engine.getUser().getId());
            String display = engine.getPropertyManager().employeesUnderContractProperties(engine.getUser().getId());
            if(role == Roles.SALES_ASSOCIATE) {

                MyUnderContractPropertiesForSale myUnderContractPropertiesForSale = new MyUnderContractPropertiesForSale();
                myUnderContractPropertiesForSale.goToUnderContractProperties(engine, display);
            } else if(role == Roles.PROPERTY_MANAGER) {

                MyUnderContractPropertiesRental myUnderContractPropertiesRental = new MyUnderContractPropertiesRental();
                myUnderContractPropertiesRental.goToUnderContractPropertiesTwo(engine, display);
            }
        }
        else if(option == 4)
        {
            double hours = Scan.askForDouble("Enter Hours Worked:");
            engine.getUserManager().inputWorkHours(engine.getUser().getId(), hours);
            goToMyEmployeeMenu(engine);
        }
        else {
            Logger logOut = new Logger();
            logOut.logUserIn();
        }
    }
}
