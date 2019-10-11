package menusForUsers.employeeMenu.underContractProperties;

import engine.SystemEngine;
import menusForUsers.employeeMenu.MyEmployeeMenu;
import utilities.scanner.Scan;

public class MyUnderContractPropertiesTwo {
    public void goToUnderContractPropertiesTwo(SystemEngine engine, String displayable){
        MyUnderContractPropertiesTwoCallBack callBack = new MyUnderContractPropertiesTwoCallBack();
        int option = Scan.askForOption(1, callBack.menu(displayable));
        if(option == 1) {
            MyEmployeeMenu employeeMenu = new MyEmployeeMenu();
            employeeMenu.goToMyEmployeeMenu(engine);
        }
    }

}
