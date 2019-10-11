package menusForUsers.employeeMenu.unadvertisedProperties;

import engine.SystemEngine;
import menusForUsers.employeeMenu.MyEmployeeMenu;
import utilities.scanner.Scan;

public class MyUnadvertisedProperties {
    public void goToUnadvertisedProperties(SystemEngine engine, String displayable){
        MyUnadvertisedPropertiesCallBack callBack = new MyUnadvertisedPropertiesCallBack();
        int option = Scan.askForOption(2, callBack.menu(displayable));
        if(option == 1) {
            goToUnadvertisedProperties(engine, displayable);
        }
        else if(option==2){
            MyEmployeeMenu employeeMenu = new MyEmployeeMenu();
            employeeMenu.goToMyEmployeeMenu(engine);
        }
    }
}
