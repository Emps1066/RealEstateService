package account;

import utilities.scanner.Scan;
import user.User;
import enums.UserType;
import systemManagers.UserManager;

public class SignIn {

    public User signIn(UserType userType) {
        UserManager userManager = new UserManager();
        User user = null;
        boolean match = false;
        String email = Scan.askForString("your email");
        String password = Scan.askForString("your password");
        if(!userManager.passwordEmailMatch(email, password, userType)) {
            System.out.println("Email or password is incorrect");
        } else {
            user = userManager.getUserByEmail(email);
            match = true;
        }

        return user;
    }
}
