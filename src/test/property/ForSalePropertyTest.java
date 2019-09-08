package property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForSalePropertyTest {


    @Test
    void getAddress() {
        Property c1 = new ForSaleProperty("2 Bourke Street Melbourne",2,3);
        System.out.println(c1.getAddress());
    }

    @Test
    void setAddress() {
        Property c1 = new ForSaleProperty("2 Bourke Street Melbourne",2,3);
        c1.setAddress("10 Swanston Street Melbourne");
        System.out.println(c1.getAddress());
    }

    @Test
    void getBedrooms() {
        Property c1 = new ForSaleProperty("2 Bourke Street Melbourne",2,3);
        System.out.println(c1.getBedrooms());
    }

    @Test
    void setBedrooms() {
        Property c1 = new ForSaleProperty("2 Bourke Street Melbourne",2,3);
        c1.setBedrooms(3);
        System.out.println(c1.getBedrooms());
    }

    @Test
    void getBathrooms() {
        Property c1 = new ForSaleProperty("2 Bourke Street Melbourne",2,3);
        System.out.println(c1.getBathrooms());
    }

    @Test
    void setBathrooms() {
        Property c1 = new ForSaleProperty("2 Bourke Street Melbourne",2,3);
        c1.setBathrooms(2);
        System.out.println(c1.getBathrooms());
    }

    @Test
    void addEmployee() {

    }

    @Test
    void addOwner() {
    }

    @Test
    void getEmployees() {
    }

    @Test
    void getOwners() {
    }
}