package menusForUsers.propertySeekaMenu;

public class PropertySeekerMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Menu\n");
        menu.append("\n");
        menu.append("Property Seeker Menu\n");
        menu.append("1. Browsing PropertySeeker Properties\n");
        menu.append("2. View My PropertySeeker Applications\n");
        menu.append("3. View My PropertySeeker Offers\n");
        menu.append("4. Log out\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
