package engine;

import com.opencsv.CSVReader;
import counts.Count;
import fileHandler.FileHandler;
import scanner.Scan;
import user.Employee;
import user.Customer;
import user.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UserManager {


    private int generateUniqueID(String userType)
    {
        int uniqueNum = Count.getCount("src\\main\\java\\csv\\IdCounts\\" + userType + "Count.csv");
        return uniqueNum;
    }

    private String formatUserID(int uniqueNum, String idSerial)
    {
        return String.format("%s%d", idSerial, uniqueNum);
    }

    private void saveUserToFile(User user, String userType)
    {
        FileHandler.writeToFile(user.toCsvString(), "src\\main\\java\\csv\\users\\" + userType + ".csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\users\\" + userType + ".csv", true);
        Count.incrementCount("src\\main\\java\\csv\\IdCounts\\" + userType + "Count.csv");
    }

    public void createUser()
    {
        String userType = null;
        String idSerial = null;
        String choice = Scan.askForString("Make an employee account or a customer account? A = Employee, B = Customer");
        String name = Scan.askForString("What is your name?");
        String email = Scan.askForString("What is your email?");
        String username = Scan.askForString("What is your username of choice?");
        //TODO method to check if username, password are unique as well as roles chosen
        String password = Scan.askForString("What is your password of choice?");


        if(choice == "A")
        {
            idSerial = "E";
            userType = "employee";
            Employee employee = new Employee(username, name, email, password);
            employee.setId(formatUserID(generateUniqueID(userType), idSerial));
            saveUserToFile(employee, userType);
        }
        else if(choice == "B")
        {
            String address = Scan.askForString("What is your address?");
            idSerial = "C";
            userType = "customer";
            Customer customer = new Customer(username, name, email, password, address);
            customer.setId(formatUserID(generateUniqueID(userType), idSerial));
            saveUserToFile(customer, userType);
        }
        else
        {
            System.out.println("Invalid input");
        }
    }

    public void printAllPendingEmployeeDetails()
    {

        String fileAddress = "src\\main\\java\\csv\\properties\\pendingEmployees.csv";
        General general = new General();
        general.printCSVToTerminal(fileAddress);

    }

    public boolean logInVerification(String userType)
    {
        boolean verified = false;
        //TODO verify username and password
        return verified;
    }


}