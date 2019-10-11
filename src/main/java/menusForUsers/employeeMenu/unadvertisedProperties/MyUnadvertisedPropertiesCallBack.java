package menusForUsers.employeeMenu.unadvertisedProperties;

public class MyUnadvertisedPropertiesCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Employee Main Menu\n");
        menu.append("  -> Unadvertised Properties Menu\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Unadvertised Properties Menu\n");
        menu.append("1. Advertise Property\n");
        menu.append("2. Back To Employee Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
