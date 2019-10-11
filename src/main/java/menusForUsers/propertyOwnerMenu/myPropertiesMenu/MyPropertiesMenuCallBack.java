package menusForUsers.propertyOwnerMenu.myPropertiesMenu;

public class MyPropertiesMenuCallBack {

    public String menu(String display) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Owner Menu\n");
        menu.append("  -> My Properties Menu\n");
        menu.append("\n");
        menu.append(display);
        menu.append("\n");
        menu.append("\n");
        menu.append("My Properties Menu\n");
        menu.append("1. Add rental property\n");
        menu.append("2. Add for sale property\n");
        menu.append("3. Edit Property Details\n");
        menu.append("4. Back to Property Owner Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
