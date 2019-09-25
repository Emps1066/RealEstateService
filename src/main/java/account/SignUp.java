package account;

import fileHandler.FileHandler;
import scanner.Scan;
import user.Employee;
import user.*;
import enums.UserType;
import engine.UserManager;

public class SignUp {
    public User signUp() {
        UserManager userManager = new UserManager();
        String name = Scan.askForString("your name");
        String email = userManager.getNewEmail(UserType.CUSTOMER);
        String password = userManager.getNewPassword();

        User user = new Customer(null, name, email, password);
        userManager.createUser((Customer) user);

        String userRow = FileHandler.get(email, 2, "src\\main\\java\\csv\\users\\" + UserType.CUSTOMER + ".csv");
        user = userManager.constructUserObjectFromString(userRow, UserType.CUSTOMER);

        return user;
    }
}
