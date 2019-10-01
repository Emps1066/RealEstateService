package menusForEmployees.branchAdmin;

public class BranchAdminMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Branch Admin Menu\n");
        menu.append("\n");
        menu.append("Branch Admin Menu");
        menu.append("1. Payroll Management\n");
        menu.append("2. Enter Documents into System\n");
        menu.append("3. Rent Management\n");
        menu.append("4. Employee Account Manager\n");
        menu.append("5. Log Out\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
