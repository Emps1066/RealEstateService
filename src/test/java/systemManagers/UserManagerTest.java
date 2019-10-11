package systemManagers;

import org.junit.jupiter.api.Test;
import user.Employee;
import user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void createUser() {
        UserManager userManager = new UserManager();
        Employee employee = new Employee("E5", "harry", "Harryluke@hotmail.com", "woow");
        userManager.createUser(employee);
        String expectedId = "E" + (IdManager.getIdCount("employee") - 1);
        User user = userManager.getUser(expectedId);
        assertTrue(employee.toCsvString().equals(user.toCsvString()));
    }
}