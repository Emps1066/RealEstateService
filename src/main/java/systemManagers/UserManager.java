package systemManagers;

import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;
import user.Employee;
import user.Customer;
import user.User;
import enums.UserType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserManager {

    private Map<String, User>  users;

    public UserManager(Map<String, User>  users) {
        this.users = users;
    }

    // GENERAL USER METHODS
    public void createUser(User user)
    {
        String Id = IdManager.generateUniqueID(user.userType().IdSerial(), user.userType().toString());
        user.setId(Id);
        addUser(user);
        IdManager.updateUniqueIdValue(user.userType().toString());
        System.out.println("User created");
    }

    public User getUser(String Id)
    {
        return users.get(Id);
    }

    public User getUserByEmail(String email)
    {
        User user = null;
        for(User userItter : users.values())
        {
            if(email.equals(userItter.getEmail()))
            {
                user = userItter;
            }
        }
        return user;
    }

    public void deleteUser(String Id) {
        users.remove(Id);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }


    // FOR CUSTOMERS
    public String allCustomersToString() {
        StringBuilder customersString = new StringBuilder();
        for(Customer customer : allCustomersList())
        {
            customersString.append(customer.toString());
            customersString.append("\n");
        }
        customersString.deleteCharAt(customersString.length() - 1);
        return customersString.toString();
    }

    private List<Customer> allCustomersList() {
        List<Customer> customers = new ArrayList<>();
        for(User user : users.values()) {
            if(user.userType() == UserType.CUSTOMER) {
                customers.add((Customer) user);
            }
        }

        return customers;
    }

    // FOR EMPLOYEES
    public String allEmployeesToString() {
        StringBuilder employeesString = new StringBuilder();
        for(Employee employee : allEmployeesList())
        {
            employeesString.append(employee.toString());
            employeesString.append("\n");
        }
        employeesString.deleteCharAt(employeesString.length() - 1);
        return employeesString.toString();
    }

    public String allCusomersToString() {
        StringBuilder employeesString = new StringBuilder();
        for(Customer employee : allCustomersList())
        {
            employeesString.append(employee.toString());
            employeesString.append("\n");
        }
        employeesString.deleteCharAt(employeesString.length() - 1);
        return employeesString.toString();
    }

    private List<Employee> allEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        for(User user : users.values()) {
            if(user.userType() == UserType.EMPLOYEE) {
                employees.add((Employee) user);
            }
        }

        return employees;
    }

    // ACCOUNT CREATION AND LOGIN METHODS
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
            password = Scan.askForString("Enter your password:");
            reEnteredPass = Scan.askForString("Enter your password again:");
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
            email = Scan.askForString("Enter your email:");
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
        for(User user : users.values())
        {
            if(email.equals(user.getEmail()))
            {
                exists = true;
            }
        }
        return exists;
    }

    public boolean passwordEmailMatch(String email, String password)
    {
        boolean match = false;
        for(User user : users.values())
        {
            if(email.equals(user.getEmail()) &&
                    password.equals(user.getPassword()))
            {
                match = true;
            }
        }
        return match;
    }

    // FILE HANDLING

    private void saveUserToFile(User user)
    {
        FileHandler.writeToFile(user.toCsvFormat(), "src\\main\\java\\csv\\users\\" + user.userType() + ".csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\users\\" + user.userType() + ".csv", true);
    }

    public void saveToSystem() {
        FileHandler.writeToFile("", "src\\main\\java\\csv\\users\\employee.csv", false);
        FileHandler.writeToFile("", "src\\main\\java\\csv\\users\\customer.csv", false);
        for(User user : users.values()) {
            saveUserToFile(user);
        }
    }
}