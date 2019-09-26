package menusForUsers.propertySeekaMenu.myOffersMenu;

public class MyOffersMenuCallback {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("  -> View My PropertySeeka Offers\n");
        menu.append("\n");
        menu.append("!!ADD METHOD TO DISPLAY OFFERS!!\n");
        menu.append("\n");
        menu.append("Property View My Offer Menu\n");
        menu.append("\n");
        menu.append("1. Make PropertySeeka Offer\n");
        menu.append("2. Withdraw My PropertySeeka Offer\n");
        menu.append("3. Back to Main Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
