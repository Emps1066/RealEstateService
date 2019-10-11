package menusForUsers.propertyOwnerMenu.myOffersMenu;

public class MyOffersMenuCallBack {

    public String menu(String display) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Owner Menu\n");
        menu.append("  -> My Offers Menu\n");
        menu.append("\n");
        menu.append(display);
        menu.append("\n");
        menu.append("My Offers Menu\n");
        menu.append("1. Accept Offers\n");
        menu.append("2. Reject Offers\n");
        menu.append("3. Back to Property Owner Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
