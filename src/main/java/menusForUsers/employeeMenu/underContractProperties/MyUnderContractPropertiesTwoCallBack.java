package menusForUsers.propertySeekaMenu.employeeMenu.underContractProperties;

public class MyUnderContractPropertiesTwoCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Employee Main Menu\n");
        menu.append("  -> Under Contract Properties Menu\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Under Contract Properties Menu\n");
        menu.append("1. Back To Employee Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
