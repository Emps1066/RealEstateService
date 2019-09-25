package account;

import scanner.Scan;
import user.Customer;
import user.Employee;
import user.User;
import enums.UserType;
import engine.UserManager;
import fileHandler.FileHandler;

public class SignIn {

    public User signIn(UserType userType) {
        UserManager userManager = new UserManager();
        String email = null;
        String password;
        boolean match = false;
        while(!match) {
            email = Scan.askForString("your email");
            password = Scan.askForString("your password");
            if(!userManager.passwordEmailMatch(email, password, userType)) {
                System.out.println("Email or password is incorrect");
            } else {
                match = true;
            }
        }

        String userRow = FileHandler.get(email, 2, "src\\main\\java\\csv\\users\\" + userType + ".csv");
        User user = userManager.constructUserObjectFromString(userRow, userType);
        return user;
    }
}
