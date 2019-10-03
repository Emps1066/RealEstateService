package menusForUsers.propertySeekaMenu.myOffersMenu;

public class MyOffersMenuCallback {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Main Menu\n");
        menu.append("  -> View My PropertySeeker Offers\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property View My Offer Menu\n");
        menu.append("1. Pay Offer Down Payment\n");
        menu.append("2. Withdraw My PropertySeeker Offer\n");
        menu.append("3. Filter by Pending Offers\n");
        menu.append("4. Filter by Accepted Offers\n");
        menu.append("5. Back to Main Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
