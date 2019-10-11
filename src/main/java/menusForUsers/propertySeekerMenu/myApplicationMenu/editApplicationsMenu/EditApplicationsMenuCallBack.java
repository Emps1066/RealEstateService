package menusForUsers.propertySeekerMenu.myApplicationMenu.editApplicationsMenu;

public class EditApplicationsMenuCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Property Seeker Main Menu\n");
        menu.append("  -> View My PropertySeeker Applications\n");
        menu.append("   -> Edit My PropertySeeker Application\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("Property View My Application Menu\n");
        menu.append("1. Edit Current Income\n");
        menu.append("2. Edit Current Occupation\n");
        menu.append("3. Edit Current Employer\n");
        menu.append("4. Edit Past Occupation\n");
        menu.append("5. Edit Past Employer");
        menu.append("6. Back My PropertySeeker Applications Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
