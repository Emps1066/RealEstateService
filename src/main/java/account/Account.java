package account;

import user.User;
import enums.UserType;
import enums.SystemFunction;
import scanner.Scan;

public class Account {
    public User logUserIn() {
        User user = null;
        AccountCallBack callBack = new AccountCallBack();
        UserType userType = chooseUserOption(callBack);
        SystemFunction logInOption = chooseLogInOption(callBack);

        if(logInOption == SystemFunction.SIGN_IN) {
            SignIn signIn = new SignIn();
            user = signIn.signIn(userType);
        } else if(logInOption == SystemFunction.SIGN_UP) {
            SignUp signUp = new SignUp();
            user = signUp.signUp(userType);
        } else if(logInOption == SystemFunction.BACK) {
            logUserIn();
        }
        return user;
    }

    private SystemFunction chooseLogInOption(AccountCallBack callBack) {
        int option = Scan.askForOption(3, callBack.chooseLoginOptionMenu());

        SystemFunction function = null;
        if(option == 1) {
            function = SystemFunction.SIGN_IN;
        } else if(option == 2) {
            function = SystemFunction.SIGN_UP;
        } else if(option == 3) {
            function = SystemFunction.BACK;
        }
        return function;
    }

    private UserType chooseUserOption(AccountCallBack callBack)
    {
        int option = Scan.askForOption(2, callBack.chooseUserTypeMenu());

        UserType userType = null;
        if(option == 1) {
            userType = UserType.CUSTOMER;
        } else if(option == 2) {
            userType = UserType.EMPLOYEE;
        }

        return userType;
    }
}
