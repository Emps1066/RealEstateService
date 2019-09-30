package menusForUsers.propertySeekaMenu.myApplicationMenu;

public class MyApplicationsMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("  -> View My PropertySeeka Applications\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property View My Application Menu\n");
        menu.append("1. Pay PropertySeeka Application Deposit\n");
        menu.append("2. Edit My PropertySeeka Application\n");
        menu.append("3. Filter By Accepted Applications\n");
        menu.append("4. Filter By Pending Applications\n");
        menu.append("5. Withdraw Application");
        menu.append("6. Back to Main Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
