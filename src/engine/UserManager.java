package engine;

import counts.Count;
import fileHandler.FileHandler;
import user.Employee;
import user.Customer;
import user.User;

public class UserManager {
    public void createEmployee(Employee employee)
    {
        createUser(employee, "employee", "E");
    }

    public void createCustomer(Customer customer) {
        createUser(customer, "customer", "C");
    }

    private void createUser(User user, String userType, String idSerial) {
        int uniqueNum = Count.getCount("src\\csv\\IdCounts\\" + userType + "Count.txt");
        user.setId(String.format("%s%d", idSerial, uniqueNum));
        FileHandler.writeToFile(user.toCsvString(), "src\\csv\\users\\" + userType + ".txt", true);
        FileHandler.writeToFile("\n", "src\\csv\\users\\" + userType + ".txt", true);
        Count.incrementCount("src\\csv\\IdCounts\\" + userType + "Count.txt");
    }
}
