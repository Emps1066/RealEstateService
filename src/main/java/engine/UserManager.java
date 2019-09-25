package engine;

import idManager.IdManager;
import fileHandler.FileHandler;
import scanner.Scan;
import user.Employee;
import user.Customer;
import user.User;
import enums.UserType;

public class UserManager {

    public void createUser(Customer customer)
    {
        UserType userType = UserType.CUSTOMER;
        createUser(customer, userType);
    }

    public void createUser(Employee employee)
    {
        UserType userType = UserType.EMPLOYEE;
        createUser(employee, userType);
    }

    private void createUser(User user, UserType userType)
    {
        String Id = IdManager.generateUniqueID(userType.IdSerial(), userType.toString());
        user.setId(Id);
        saveUserToFile(user, userType.toString());
    }

    public void printAllPendingEmployeeDetails()
    {
        String fileAddress = "src\\main\\java\\csv\\properties\\pendingEmployees.csv";
    }

    public boolean passwordIsValid(String password, String reEnteredPassword)
    {
        boolean isValid = false;

        if(password.equals(reEnteredPassword))
        {
            isValid = true;
        }
        return isValid;
    }

    public String getNewPassword()
    {
        boolean validPass = false;
        String password = null;
        String reEnteredPass;
        while(!validPass)
        {
            password = Scan.askForString("your password");
            reEnteredPass = Scan.askForString("your password again");
            validPass = passwordIsValid(password, reEnteredPass);
            if(!validPass) {
                System.out.println("Passwords do not match please try again");
            }
        }
        return password;
    }

    public String getNewEmail(UserType userType)
    {
        boolean validEmail = false;
        String email = null;
        while(!validEmail)
        {
            email = Scan.askForString("your email");
            email = email.toLowerCase();
            if(emailExists(email, userType))
            {
                System.out.println("Email is already in use please enter a different one");
            }
            else {
                validEmail = true;
            }
        }
        return email;
    }

    public boolean emailExists(String email, UserType userType)
    {
        boolean exists = false;
        int numOfUsers = IdManager.getIdCount(userType.toString());
        String userRow;
        for(int loop = 0; loop < numOfUsers && !exists; loop++)
        {
            userRow = FileHandler.get(email, 2,"src\\main\\java\\csv\\users\\" + userType + ".csv");
            if(userRow != null)
            {
                exists = true;
            }
        }
        return exists;
    }

    public boolean passwordEmailMatch(String email, String password, UserType userType)
    {
        boolean match = false;
        int numOfUsers = IdManager.getIdCount(userType.toString());
        String userRow = null;
        for(int loop = 0; loop < numOfUsers && !match; loop++)
        {
            userRow = FileHandler.get(email, 2,"src\\main\\java\\csv\\users\\" + userType + ".csv");
            if(userRow !=  null)
            {
                String userDetails[] = userRow.split(",");
                if (userDetails[2].equals(email) && userDetails[3].equals(password))
                {
                    match = true;
                }
            }
        }
        return match;
    }

    public User constructUserObjectFromString(String userRow, UserType userType)
    {
        String userDetails[] = userRow.split(",");
        User user = null;
        if(userType == UserType.EMPLOYEE)
        {
            user = new Employee(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
        } else if(userType == UserType.CUSTOMER)
        {
            user = new Customer(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
        }
        return user;
    }

    private void saveUserToFile(User user, String userType)
    {
        FileHandler.writeToFile(user.toCsvString(), "src\\main\\java\\csv\\users\\" + userType + ".csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\users\\" + userType + ".csv", true);
        IdManager.updateUniqueIdValue(userType);
    }

}