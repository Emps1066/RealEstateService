package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

public class BrowseRentalMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("  -> Browsing PropertySeeka Properties\n");
        menu.append("   -> Filter By Rent Property\n");
        menu.append("\n");
        menu.append("!!ADD METHOD TO DISPLAY PROPERTIES!!\n");
        menu.append("\n");
        menu.append("Property Filter By Rent Menu\n");
        menu.append("\n");
        menu.append("1. Make PropertySeeka Offer\n");
        menu.append("2. Back to Browsing Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
