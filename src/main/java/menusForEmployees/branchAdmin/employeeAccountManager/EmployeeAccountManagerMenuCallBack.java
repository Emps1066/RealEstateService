package menusForEmployees.branchAdmin.employeeAccountManager;

public class EmployeeAccountManagerMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Branch Admin Menu\n");
        menu.append("\n");
        menu.append("Employee Account Manager Menu");
        menu.append("1. Create New Employee Account\n");
        menu.append("2. Update Existing Employee Account Information\n");
        menu.append("3. Delete Employee Account\n");
        menu.append("4. Branch Admin Menu\n");
        menu.append("5. Log Out\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
