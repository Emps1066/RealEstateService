package account;

import user.User;
import enums.UserType;
import enums.SystemFunction;
import utilities.scanner.Scan;

public class Account
{
    public User logUserIn()
    {
        User user = null;
        AccountCallBack callBack = new AccountCallBack();
        UserType userType = chooseUserOption(callBack);
        SystemFunction logInOption = chooseLogInOption(callBack, userType);

        if(logInOption == SystemFunction.SIGN_IN)
        {
            SignIn signIn = new SignIn();
            user = signIn.signIn(userType);
        }
        else if(logInOption == SystemFunction.SIGN_UP)
        {
            SignUp signUp = new SignUp();
            user = signUp.signUp();
        }
        else if(logInOption == SystemFunction.BACK)
        {
            logUserIn();
        }

        if(user == null)
        {
            logUserIn();
        }
        return user;
    }

    private SystemFunction chooseLogInOption(AccountCallBack callBack, UserType userType)
    {
        int option = 0;
        SystemFunction function = null;
        if(userType == UserType.EMPLOYEE)
        {
            option = Scan.askForOption(2, callBack.employeeChooseLoginOptionMenu());
            if(option == 1)
            {
                function = SystemFunction.SIGN_IN;
            }
            else if(option == 2)
            {
                function = SystemFunction.BACK;
            }
        }
        else if(userType == UserType.CUSTOMER)
        {
            option = Scan.askForOption(3, callBack.customerChooseLoginOptionMenu());
            if(option == 1)
            {
                function = SystemFunction.SIGN_IN;
            }
            else if(option == 2)
            {
                function = SystemFunction.SIGN_UP;
            }
            else if(option == 3)
            {
                function = SystemFunction.BACK;
            }
        }
        return function;
    }

    private UserType chooseUserOption(AccountCallBack callBack)
    {
        int option = Scan.askForOption(2, callBack.chooseUserTypeMenu());

        UserType userType = null;
        if(option == 1)
        {
            userType = UserType.CUSTOMER;
        }
        else if(option == 2)
        {
            userType = UserType.EMPLOYEE;
        }

        return userType;
    }
}
