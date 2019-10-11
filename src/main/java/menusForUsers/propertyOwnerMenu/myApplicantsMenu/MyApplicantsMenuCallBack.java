package menusForUsers.propertyOwnerMenu.myApplicantsMenu;

public class MyApplicantsMenuCallBack {

    public String menu(String display) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Owner Menu\n");
        menu.append("  -> My Applicants Menu\n");
        menu.append("\n");
        menu.append(display);
        menu.append("\n");
        menu.append("My Applicants Menu\n");
        menu.append("1. Accept Applications\n");
        menu.append("2. Reject Applications\n");
        menu.append("3. Back to Property Owner Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
