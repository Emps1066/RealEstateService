package account;

public class AccountCallBack {
    public String chooseUserTypeMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Log in as:\n");
        menu.append("1.Customer\n");
        menu.append("2.Employee");
        return menu.toString();
    }

    public String customerChooseLoginOptionMenu()
    {
        StringBuilder menu = new StringBuilder();
        menu.append("1.Sign in\n");
        menu.append("2.Sign up\n");
        menu.append("3.Back");
        return menu.toString();
    }

    public String employeeChooseLoginOptionMenu()
    {
        StringBuilder menu = new StringBuilder();
        menu.append("1.Sign in\n");
        menu.append("2.Back");
        return menu.toString();
    }

}
