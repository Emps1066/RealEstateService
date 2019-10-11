package menusForUsers.propertyOwnerMenu;

public class PropertyOwnerMenuCallBack {

    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Owner Menu\n");
        menu.append("\n");
        menu.append("Property Owner Menu");
        menu.append("1. My Properties\n");
        menu.append("2. My Property's Applicants\n");
        menu.append("3. My Property's Offers\n");
        menu.append("4. Log out\n");
        menu.append("*******************************************");

        return menu.toString();

    }
}
