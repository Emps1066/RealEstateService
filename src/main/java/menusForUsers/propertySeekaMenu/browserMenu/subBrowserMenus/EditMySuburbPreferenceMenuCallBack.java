package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

public class EditMySuburbPreferenceMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Main Menu\n");
        menu.append("  -> Browsing PropertySeeker Properties\n");
        menu.append("   -> Filter By My Preference\n");
        menu.append("    -> Edit My Preferences\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property Edit My Preference Menu\n");
        menu.append("1. Add Preference\n");
        menu.append("2. Delete Preference\n");
        menu.append("3. Apply Filter\n");
        menu.append("4. Back to Filter My Preference Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
