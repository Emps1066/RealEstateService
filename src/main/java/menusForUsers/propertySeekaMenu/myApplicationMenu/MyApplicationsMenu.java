package menusForUsers.propertySeekaMenu.myApplicationMenu;


import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.PropertySeekerMenu;
import menusForUsers.propertySeekaMenu.myApplicationMenu.editApplicationsMenu.EditApplicationsMenu;
import systemManagers.ApplicationManager;
import utilities.scanner.Scan;

public class MyApplicationsMenu {
    public void goToMyApplicationsMenu(SystemEngine engine, String displayable) {
        MyApplicationsMenuCallBack callBack = new MyApplicationsMenuCallBack();
        int option = Scan.askForOption(6, callBack.menu(displayable));
        if(option == 1)
        {
            String applicationId = Scan.askForString("Enter Application Id To Finalise:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.finaliseApplication(applicationId, engine.getUser().getId(),
                    engine.getPropertyManager());

            String display = applicationManager.propertySeekerAllAppsToListFormat(engine.getUser().getId());
            goToMyApplicationsMenu(engine, display);
        }
        else if(option == 2)
        {
            String applicationId = Scan.askForString("Enter Application Id To Edit:");
            ApplicationManager applicationManager = engine.getApplicationManager();
            if(applicationManager.userCanEdit(applicationId, engine.getUser().getId())) {

                String display = applicationManager.getApplicationString(applicationId);
                EditApplicationsMenu menu = new EditApplicationsMenu();
                menu.goToEditApplicationsMenu(engine, display, applicationId);
            } else {
                System.out.println("Application Does Not Exist Or You Are Not Allowed To Edit");
                goToMyApplicationsMenu(engine, displayable);
            }
        }
        else if(option == 3)
        {
            ApplicationManager applicationManager = engine.getApplicationManager();
            String display = applicationManager.propertySeekerAcceptedAppsToListFormat(engine.getUser().getId());
            goToMyApplicationsMenu(engine, display);
        }
        else if(option == 4)
        {
            ApplicationManager applicationManager = engine.getApplicationManager();
            String display = applicationManager.propertySeekerPendingAppsToListFormat(engine.getUser().getId());
            goToMyApplicationsMenu(engine, display);
        }
        else if(option == 5)
        {
            String applicationId = Scan.askForString("Enter Application Id To Withdraw:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.withdrawApplication(applicationId, engine.getUser().getId());
            String display = applicationManager.propertySeekerAllAppsToListFormat(engine.getUser().getId());
            goToMyApplicationsMenu(engine, display);
        }
        else {
            PropertySeekerMenu menu = new PropertySeekerMenu();
            menu.goToMainMenu(engine);
        }
    }
}
