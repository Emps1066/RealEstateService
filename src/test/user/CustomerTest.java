package user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
// Basic test code to check if the methods are doing their jobs
    @Test
    void getId() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getId());
    }

    @Test
    void getUserName() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getUserName());
    }

    @Test
    void setUserName() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getName());
        c1.setUserName("user2");
        System.out.println(c1.getUserName());
    }

    @Test
    void getPassword() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getPassword());
    }

    @Test
    void setPassword() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getName());
        c1.setPassword("p4567");
        System.out.println(c1.getPassword());
    }

    @Test
    void getName() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getName());
    }

    @Test
    void setName() {
        User c1 = new Customer("user1","p1234","John","id123");
        System.out.println(c1.getName());
        c1.setName("Jenny");
        System.out.println(c1.getName());
    }

    @Test
    void getRoles() {

    }
}