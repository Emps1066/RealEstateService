package menusForUsers.propertyManagerMenu;

public class PropertyManagerMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Manager Main Menu\n");
        menu.append("\n");
        menu.append("Property Main Menu");
        menu.append("1. Browsing PropertyManager Properties\n");
        menu.append("2. View My PropertyManager Applications\n");
        menu.append("3. View My PropertyManager Offers\n");
        menu.append("4. Log out\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
