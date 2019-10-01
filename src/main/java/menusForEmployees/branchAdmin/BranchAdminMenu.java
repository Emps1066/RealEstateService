package menusForEmployees.branchAdmin;

import account.Account;
import engine.SystemEngine;
import menusForEmployees.branchAdmin.documentManager.DocumentManagerMenu;
import menusForEmployees.branchAdmin.employeeAccountManager.EmployeeAccountManagerMenu;
import menusForEmployees.branchAdmin.payrollMenu.PayrollManagerMenu;
import menusForEmployees.branchAdmin.rentManagement.RentManagementMenu;
import utilities.scanner.Scan;

public class BranchAdminMenu {
    public void goToBranchAdminMenu(SystemEngine engine) {
        BranchAdminMenuCallBack callBack = new BranchAdminMenuCallBack();
        int option = Scan.askForOption(5, callBack.menu());
        if (option == 1) {
            PayrollManagerMenu menu = new PayrollManagerMenu();
            menu.goToPayrollManagerMenu(engine, "");
        } else if (option == 2) {
            DocumentManagerMenu menu = new DocumentManagerMenu();
            menu.goToDocumentManagerMenu(engine,"");
        } else if (option == 3) {
            RentManagementMenu menu = new RentManagementMenu();
            menu.goToRentManagementMenu(engine, "");
        } else if (option == 4){
            EmployeeAccountManagerMenu menu = new EmployeeAccountManagerMenu();
            menu.goToEmployeeAccountManagerMenu(engine,"");
        } else if (option == 5) {
            Account logOut = new Account();
            logOut.logUserIn();
        }
    }
}
