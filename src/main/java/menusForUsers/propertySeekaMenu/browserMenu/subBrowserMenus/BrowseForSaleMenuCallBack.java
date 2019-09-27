package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;

public class BrowseForSaleMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("  -> Browsing PropertySeeka Properties\n");
        menu.append("   -> Filter By Sale Property\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property Filter By Sale Menu\n");
        menu.append("1. Send PropertySeeka Application\n");
        menu.append("2. Back to Browsing Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
