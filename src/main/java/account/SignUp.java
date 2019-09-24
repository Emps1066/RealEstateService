package account;

import fileHandler.FileHandler;
import scanner.Scan;
import user.Employee;
import user.*;
import enums.UserType;
import engine.UserManager;

public class SignUp {
    public User signUp(UserType userType) {
        String name = Scan.askForString("your name");
        String email = getNewEmail(userType);
        String password = getNewPassword();

        UserManager userManager = new UserManager();
        User user = null;
        if(userType == UserType.EMPLOYEE) {
            user = new Employee(null, name, email, password);
            userManager.createUser((Employee) user);
        } else if(userType == UserType.CUSTOMER) {
            user = new Customer(null, name, email, password);
            userManager.createUser((Customer) user);
        }

        String userRow = FileHandler.get(email, 2, "src\\main\\java\\csv\\users\\" + userType + ".csv");
        user = userManager.constructUserObject(userRow, userType);

        return user;
    }

    public boolean passwordIsValid(String password, String reEnteredPassword) {
        boolean isValid = false;

        if(password.equals(reEnteredPassword)) {
            isValid = true;
        }
        return isValid;
    }

    private String getNewPassword() {
        boolean validPass = false;
        String password = null;
        String reEnteredPass;
        while(!validPass) {
            password = Scan.askForString("your password");
            reEnteredPass = Scan.askForString("your password again");
            validPass = passwordIsValid(password, reEnteredPass);
            if(!validPass) {
                System.out.println("Passwords do not match please try again");
            }
        }
        return password;
    }

    private String getNewEmail(UserType userType) {
        UserManager userManager = new UserManager();
        boolean validEmail = false;
        String email = null;
        while(!validEmail) {
            email = Scan.askForString("your email");
            email = email.toLowerCase();
            if(userManager.emailExists(email, userType)) {
                System.out.println("Email is already in use please enter a different one");
            } else {
                validEmail = true;
            }
        }
        return email;
    }
}
