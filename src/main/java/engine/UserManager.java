package engine;

import counts.Count;
import fileHandler.FileHandler;
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

    private void createUser(User user, UserType userType) {
        String Id = formatUserID(generateUniqueID(userType.toString()), userType.IdSerial());
        user.setId(Id);
        saveUserToFile(user, userType.toString());
    }

    public void printAllPendingEmployeeDetails()
    {
        String fileAddress = "src\\main\\java\\csv\\properties\\pendingEmployees.csv";
        General general = new General();
        general.printCSVToTerminal(fileAddress);
    }

    public boolean emailExists(String email, UserType userType) {
        boolean exists = false;
        int numOfUsers = generateUniqueID(userType.toString());
        String userRow;
        for(int loop = 0; loop < numOfUsers && !exists; loop++) {
            userRow = FileHandler.get(email, 2,"src\\main\\java\\csv\\users\\" + userType + ".csv");
            if(userRow != null) {
                exists = true;
            }
        }
        return exists;
    }

    public boolean passwordEmailMatch(String email, String password, UserType userType) {
        boolean match = false;
        int numOfUsers = generateUniqueID(userType.toString());
        String userRow = null;
        for(int loop = 0; loop < numOfUsers && !match; loop++) {
            userRow = FileHandler.get(email, 2,"src\\main\\java\\csv\\users\\" + userType + ".csv");
            if(userRow !=  null) {
                String userDetails[] = userRow.split(",");
                if (userDetails[2].equals(email) && userDetails[3].equals(password)) {
                    match = true;
                }
            }
        }
        return match;
    }

    public User constructUserObject(String userRow, UserType userType) {
        String userDetails[] = userRow.split(",");
        User user = null;
        if(userType == UserType.EMPLOYEE) {
            user = new Employee(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
        } else if(userType == UserType.CUSTOMER) {
            user = new Customer(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
        }
        return user;
    }

    public boolean verifyAccount(String userType)
    {
        boolean verified = false;
        //TODO verify username and password
        return verified;
    }

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

}