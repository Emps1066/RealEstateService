package menusForUsers.menuType;

public class ChooseCustomerInterfaceMenuCallBack {
    public String menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("          Welcome to S&E\n");
        menu.append("1. Log in as property seeker\n");
        menu.append("2. Log in as property owner");
        return menu.toString();
    }
}
