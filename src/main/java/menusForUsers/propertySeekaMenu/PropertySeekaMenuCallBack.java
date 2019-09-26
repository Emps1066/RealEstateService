package menusForUsers.propertySeekaMenu;

public class PropertySeekaMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("\n");
        menu.append("Property Main Menu");
        menu.append("\n");
        menu.append("1. Browsing PropertySeeka Properties\n");
        menu.append("2. View My PropertySeeka Applications\n");
        menu.append("3. View My PropertySeeka Offers\n");
        menu.append("4. Log out\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
