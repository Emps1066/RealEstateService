package menusForUsers.propertySeekerMenu.myApplicationMenu;

public class MyApplicationsMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Main Menu\n");
        menu.append("  -> View My PropertySeeker Applications\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("Property View My Application Menu\n");
        menu.append("1. Pay PropertySeeker Application Deposit\n");
        menu.append("2. Edit My PropertySeeker Application\n");
        menu.append("3. Filter By Accepted Applications\n");
        menu.append("4. Filter By Pending Applications\n");
        menu.append("5. Withdraw Application\n");
        menu.append("6. Back to Main Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
