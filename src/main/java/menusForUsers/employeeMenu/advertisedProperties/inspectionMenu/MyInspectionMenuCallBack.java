package menusForUsers.propertySeekaMenu.employeeMenu.advertisedProperties.inspectionMenu;

public class MyInspectionMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Employee Main Menu\n");
        menu.append("  -> Advertised Properties Menu\n");
        menu.append("   -> Inspection Menu\n");

        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Inspection Menu\n");
        menu.append("1. Create Inspection\n");
        menu.append("2. Cancel Inspection\n");
        menu.append("3. Back To Advertised Properties Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
