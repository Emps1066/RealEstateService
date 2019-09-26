package menusForUsers.propertySeekaMenu.myApplicationMenu;


import menusForUsers.propertySeekaMenu.PropertySeekaMenu;
import scanner.Scan;

public class MyApplicationsMenu {
    public void goToMyApplicationsMenu() {
        MyApplicationsMenuCallBack callBack = new MyApplicationsMenuCallBack();
        int option = Scan.askForOption(3, callBack.menu());
        if(option == 1)
        {
            goToMyApplicationsMenu();
        }
        else if(option == 2)
        {
            goToMyApplicationsMenu();
        }
        else {
            PropertySeekaMenu menu = new PropertySeekaMenu();
            menu.goToMainMenu();
        }
    }
}
