package menusForUsers.employeeMenu.underContractProperties;

public class MyUnderContractPropertiesCallBack {
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
        menu.append("1. Pay Bills\n");
        menu.append("2. Pay Management Fees\n");
        menu.append("3. Back To Employee Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
