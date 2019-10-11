package menusForUsers.employeeMenu.underContractProperties;

import engine.SystemEngine;
import menusForUsers.employeeMenu.MyEmployeeMenu;
import utilities.scanner.Scan;

public class MyUnderContractProperties {
    public void goToUnderContractProperties(SystemEngine engine, String displayable){
        MyUnderContractPropertiesCallBack callBack = new MyUnderContractPropertiesCallBack();
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
