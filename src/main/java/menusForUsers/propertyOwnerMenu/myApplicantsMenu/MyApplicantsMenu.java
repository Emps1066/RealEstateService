package menusForUsers.propertyOwnerMenu.myApplicantsMenu;

import menusForUsers.propertyOwnerMenu.PropertyOwnerMenu;
import engine.SystemEngine;
import systemManagers.ApplicationManager;
import utilities.scanner.Scan;

public class MyApplicantsMenu {

    public void goToMyApplicantsMenu(SystemEngine engine, String displayable ) {
        MyApplicantsMenuCallBack callBack = new  MyApplicantsMenuCallBack();
        int option = Scan.askForOption(3, callBack.menu(displayable));

        ApplicationManager applicationManager = engine.getApplicationManager();
        if(option == 1) {
            String appId = Scan.askForString("Enter The ID Of The Application To Accept:");

            applicationManager.acceptApplication(appId, engine.getUser().getId(), engine.getPropertyManager());
        }
        else if(option == 2)
        {
            String appId = Scan.askForString("Enter The ID Of The Application To Reject:");

            applicationManager.rejectApplication(appId, engine.getUser().getId());
        }
        else {
            PropertyOwnerMenu menu = new PropertyOwnerMenu ();
            menu.goToPropertyOwnerMenu(engine);
        }

        String display = applicationManager.propertyOwnerAppsToListFormat(engine.getUser().getId());
        goToMyApplicantsMenu(engine, display);
    }

}
