package menusForEmployees.branchAdmin.documentManager;

import account.Account;
import engine.SystemEngine;
import menusForEmployees.branchAdmin.BranchAdminMenu;
import utilities.scanner.Scan;

public class DocumentManagerMenu {
    public void goToDocumentManagerMenu(SystemEngine engine, String displayable){
        System.out.println(displayable);
        DocumentManagerMenuCallBack callBack = new DocumentManagerMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if (option == 1) {

        } else if (option == 2) {

        } else if (option == 3) {
            BranchAdminMenu menu = new BranchAdminMenu();
            menu.goToBranchAdminMenu(engine);
        } else if (option == 4) {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
