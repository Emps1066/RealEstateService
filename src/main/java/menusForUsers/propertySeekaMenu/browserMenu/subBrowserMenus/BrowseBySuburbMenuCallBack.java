package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

public class BrowseBySuburbMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("  -> Browsing PropertySeeka Properties\n");
        menu.append("   -> Filter By My Preference\n");
        menu.append("\n");
        menu.append("!!ADD METHOD TO DISPLAY PROPERTIES!!\n");
        menu.append("\n");
        menu.append("Property Filter By My Preference Menu\n");
        menu.append("\n");
        menu.append("1. Edit My Preferences\n");
        menu.append("2. Send PropertySeeka Application\n");
        menu.append("3. Make PropertySeeka Offer\n");
        menu.append("4. Back to Browsing Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
