package menusForUsers.employeeMenu.underContractProperties;

import engine.SystemEngine;
import menusForUsers.employeeMenu.MyEmployeeMenu;
import utilities.scanner.Scan;

public class MyUnderContractPropertiesRental {
    public void goToUnderContractPropertiesTwo(SystemEngine engine, String displayable){
        MyUnderContractPropertiesRentalCallBack callBack = new MyUnderContractPropertiesRentalCallBack();
        int option = Scan.askForOption(1, callBack.menu(displayable));
        if(option == 1) {
            MyEmployeeMenu employeeMenu = new MyEmployeeMenu();
            employeeMenu.goToMyEmployeeMenu(engine);
        }
    }

}
