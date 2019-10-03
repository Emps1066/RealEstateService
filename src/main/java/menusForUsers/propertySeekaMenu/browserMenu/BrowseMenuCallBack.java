package menusForUsers.propertySeekaMenu.browserMenu;

public class BrowseMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Main Menu\n");
        menu.append("  -> Browsing PropertySeeker Properties\n");
        menu.append("\n");
        menu.append("Property Browsing Menu\n");
        menu.append("1. Filter By Rental Property\n");
        menu.append("2. Filter By For Sale Property\n");
        menu.append("3. Filter By My Preference\n");
        menu.append("4. Back to Main Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
