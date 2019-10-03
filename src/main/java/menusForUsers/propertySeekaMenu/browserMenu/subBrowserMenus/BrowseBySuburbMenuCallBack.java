package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

public class BrowseBySuburbMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Main Menu\n");
        menu.append("  -> Browsing PropertySeeker Properties\n");
        menu.append("   -> Filter By My Preference\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property Filter By My Preference Menu\n");
        menu.append("1. Edit My Preferences\n");
        menu.append("2. Send PropertySeeker Application\n");
        menu.append("3. Make PropertySeeker Offer\n");
        menu.append("4. Back to Browsing Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
