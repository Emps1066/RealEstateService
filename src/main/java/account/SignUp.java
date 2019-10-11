package account;

import utilities.scanner.Scan;
import user.*;
import enums.UserType;
import systemManagers.UserManager;

public class SignUp {
    public User signUp(UserManager userManager) {
        String name = Scan.askForString("Enter your name:");
        String email = userManager.getNewEmail(UserType.CUSTOMER);
        String password = userManager.getNewPassword();

        User user = new Customer(null, name, email, password);
        userManager.createUser(user);
        user = userManager.getUserByEmail(email);

        return user;
    }
}
