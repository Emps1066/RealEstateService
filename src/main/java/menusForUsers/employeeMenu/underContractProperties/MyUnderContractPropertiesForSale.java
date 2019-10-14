package menusForUsers.employeeMenu.underContractProperties;

import engine.SystemEngine;
import menusForUsers.employeeMenu.MyEmployeeMenu;
import utilities.scanner.Scan;

public class MyUnderContractPropertiesForSale {
    public void goToUnderContractProperties(SystemEngine engine, String displayable){
        MyUnderContractPropertiesForSaleCallBack callBack = new MyUnderContractPropertiesForSaleCallBack();
        int option = Scan.askForOption(2, callBack.menu(displayable));
        if(option == 1) {
            goToUnderContractProperties(engine, displayable);
        }
        else if(option == 2) {
            goToUnderContractProperties(engine, displayable);
        }
        else {
            MyEmployeeMenu employeeMenu = new MyEmployeeMenu();
            employeeMenu.goToMyEmployeeMenu(engine);
        }
    }
}
