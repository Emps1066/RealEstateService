package menusForUsers.propertySeekaMenu.myApplicationMenu;

public class MyApplicationsMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeka Main Menu\n");
        menu.append("  -> View My PropertySeeka Applications\n");
        menu.append("\n");
        menu.append("!!ADD METHOD TO DISPLAY APPLICATIONS!!\n");
        menu.append("\n");
        menu.append("Property View My Application Menu\n");
        menu.append("\n");
        menu.append("1. Send My PropertySeeka Application\n");
        menu.append("2. Edit My PropertySeeka Application\n");
        menu.append("3. Back to Main Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
