package menusForUsers.propertySeekaMenu.myApplicationMenu.editApplicationsMenu;

import engine.SystemEngine;
import menusForUsers.propertySeekaMenu.myApplicationMenu.MyApplicationsMenu;
import systemManagers.ApplicationManager;
import utilities.scanner.Scan;

public class EditApplicationsMenu {
    public void goToEditApplicationsMenu(SystemEngine engine, String displayable, String applicationId) {
        EditApplicationsMenuCallBack callBack = new EditApplicationsMenuCallBack();

        int option = Scan.askForOption(6, callBack.menu(displayable));
        if(option == 1)
        {
            double currentIncome = Scan.askForDouble("Enter New Current Income:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.updateCurrentIncome(applicationId, currentIncome);

            String display = applicationManager.getApplicationString(applicationId);
            goToEditApplicationsMenu(engine, display, applicationId);
        }
        else if(option == 2)
        {
            String currentOccupation = Scan.askForString("Enter New Current Occupation:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.updateCurrentOccupation(applicationId, currentOccupation);

            String display = applicationManager.getApplicationString(applicationId);
            goToEditApplicationsMenu(engine, display, applicationId);
        }
        else if(option == 3)
        {
            String currentEmployer = Scan.askForString("Enter New Current Employer:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.updateCurrentEmployer(applicationId, currentEmployer);

            String display = applicationManager.getApplicationString(applicationId);
            goToEditApplicationsMenu(engine, display, applicationId);
        }
        else if(option == 4)
        {
            String pastOccupation = Scan.askForString("Enter New Past Occupation:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.updatePastOccupation(applicationId, pastOccupation);

            String display = applicationManager.getApplicationString(applicationId);
            goToEditApplicationsMenu(engine, display, applicationId);
        }
        else if(option == 5)
        {
            String pastEmployer = Scan.askForString("Enter New Past Employer:");

            ApplicationManager applicationManager = engine.getApplicationManager();
            applicationManager.updatePastEmployer(applicationId, pastEmployer);

            String display = applicationManager.getApplicationString(applicationId);
            goToEditApplicationsMenu(engine, display, applicationId);
        }
        else {
            ApplicationManager applicationManager = engine.getApplicationManager();
            String display = applicationManager.propertySeekerAllAppsToListFormat(engine.getUser().getId());

            MyApplicationsMenu menu = new MyApplicationsMenu();
            menu.goToMyApplicationsMenu(engine, display);
        }
    }
}
