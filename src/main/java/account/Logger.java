package account;

import engine.SystemEngine;
import systemManagers.*;
import user.User;
import enums.UserType;
import enums.SystemFunction;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

import java.util.Map;

public class Logger {
    public SystemEngine logUserIn() {
        FileHandler fileHandler = new FileHandler();
        Map<String, User> users = fileHandler.readUsersFile();
        UserManager userManager = new UserManager(users);

        User user = null;
        LoggerCallBack callBack = new LoggerCallBack();
        UserType userType = chooseUserOption(callBack);
        SystemFunction logInOption = chooseLogInOption(callBack, userType);

        if (logInOption == SystemFunction.SIGN_IN) {
            SignIn signIn = new SignIn();
            user = signIn.signIn(userManager);
        } else if (logInOption == SystemFunction.SIGN_UP) {
            SignUp signUp = new SignUp();
            user = signUp.signUp(userManager);
        } else if (logInOption == SystemFunction.BACK) {
            logUserIn();
        }
        SystemEngine engine = null;
        if (user == null) {
            logUserIn();
        } else {
            PropertyManager propertyManager = new PropertyManager(fileHandler.readPropertyManagerComponents("approved"), fileHandler.readPropertyManagerComponents("pending"), fileHandler.readPropertyManagerComponents("underContract"));
            OfferManager offerManager = new OfferManager(fileHandler.readOfferManager(propertyManager));
            ApplicationManager applicationManager = new ApplicationManager(fileHandler.readApplicationManager(propertyManager));
            InspectionManager inspectionManager = new InspectionManager(propertyManager);
            engine = new SystemEngine(user, propertyManager, userManager, applicationManager, offerManager, inspectionManager);

        }
        return engine;
    }

    private SystemFunction chooseLogInOption(LoggerCallBack callBack, UserType userType) {
        int option;
        SystemFunction function = null;
        if (userType == UserType.EMPLOYEE) {
            option = Scan.askForOption(2, callBack.employeeChooseLoginOptionMenu());
            if (option == 1) {
                function = SystemFunction.SIGN_IN;
            } else if (option == 2) {
                function = SystemFunction.BACK;
            }
        } else if (userType == UserType.CUSTOMER) {
            option = Scan.askForOption(3, callBack.customerChooseLoginOptionMenu());
            if (option == 1) {
                function = SystemFunction.SIGN_IN;
            } else if (option == 2) {
                function = SystemFunction.SIGN_UP;
            } else if (option == 3) {
                function = SystemFunction.BACK;
            }
        }
        return function;
    }

    private UserType chooseUserOption(LoggerCallBack callBack) {
        int option = Scan.askForOption(2, callBack.chooseUserTypeMenu());

        UserType userType = null;
        if (option == 1) {
            userType = UserType.CUSTOMER;
        } else if (option == 2) {
            userType = UserType.EMPLOYEE;
        }

        return userType;
    }
}
