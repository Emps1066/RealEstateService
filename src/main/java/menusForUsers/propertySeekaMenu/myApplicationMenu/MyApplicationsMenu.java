package menusForUsers.propertySeekaMenu.myApplicationMenu;


import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.PropertySeekaMenu;
import utilities.scanner.Scan;

public class MyApplicationsMenu {
    public void goToMyApplicationsMenu(SystemEngine engine, String displayable) {
        MyApplicationsMenuCallBack callBack = new MyApplicationsMenuCallBack();
        int option = Scan.askForOption(5, callBack.menu(displayable));
        if(option == 1)
        {
            goToMyApplicationsMenu(engine, displayable);
        }
        else if(option == 2)
        {
            String display = "";
            goToMyApplicationsMenu(engine, display);
        }
        else if(option == 3)
        {
            String display = "";
            goToMyApplicationsMenu(engine, display);
        }
        else if(option == 4)
        {
            String display = "";
            goToMyApplicationsMenu(engine, display);
        }
        else if(option == 5)
        {
            String display = "";
            goToMyApplicationsMenu(engine, display);
        }
        else {
            PropertySeekaMenu menu = new PropertySeekaMenu();
            menu.goToMainMenu(engine);
        }
    }
}
