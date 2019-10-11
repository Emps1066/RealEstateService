package menusForUsers.propertySeekaMenu.employeeMenu;


public class MyEmployeeMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Employee Main Menu\n");
        menu.append("\n");
        menu.append("Employee Main Menu");
        menu.append("1. List Advertised Properties\n");
        menu.append("2. List Unadvertised Properties\n");
        menu.append("3. List Under Contract Properties\n");
        menu.append("4. Input Work Hours\n");
        menu.append("5. Logout\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
