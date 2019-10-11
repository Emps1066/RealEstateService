package account;

import utilities.scanner.Scan;
import user.User;
import enums.UserType;
import systemManagers.UserManager;

public class SignIn {

    public User signIn(UserManager userManager) {
        User user = null;
        String email = Scan.askForString("your email");
        String password = Scan.askForString("your password");
        if(!userManager.passwordEmailMatch(email, password)) {
            System.out.println("Email or password is incorrect");
        } else {
            user = userManager.getUserByEmail(email);
        }

        return user;
    }
}
