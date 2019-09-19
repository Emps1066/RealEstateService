package test.property;
import user.Employee; 
import property.Property;
import property.ForSaleProperty;

import org.junit.jupiter.api.Test;

class ForSalePropertyTest {
    
    @Test
    void getID(){
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getID());
    }

    @Test
    void setID(){
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getID());
        c1.setID("10 Swanston Street Melbourne");
        System.out.println(c1.getID());
    }
    
    @Test
    void getAddress() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getAddress());
    }

    @Test
    void setAddress() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getAddress());
        c1.setAddress("10 Swanston Street Melbourne");
        System.out.println(c1.getAddress());
    }

    @Test
    void getSuburb(){
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getSuburb());
    }
    
    @Test
    void setSuburb(){ 
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getSuburb());
        c1.setSuburb("Fitzroy");
        System.out.println(c1.getSuburb());
    }
    
    @Test
    void getBedrooms() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getBedrooms());
    }

    @Test
    void setBedrooms() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getBathrooms());
        c1.setBedrooms(4);
        System.out.println(c1.getBedrooms());
    }

    @Test
    void getBathrooms() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getBathrooms());
    }

    @Test
    void setBathrooms() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        c1.setBathrooms(2);
        System.out.println(c1.getBathrooms());
    }*/

    @Test
    void addEmployee() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        Employee e1 = new Employee("Jack", "ROCKET47", "ter001"); 
        c1.addEmployee(e1); 

    }

    @Test
    void addOwner() {
    }

    @Test
    void getEmployees() {
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getEmployees());
    }

    @Test
    void getOwners() {
    }
    
    @Test
    void getCarSpaces(){
    Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        System.out.println(c1.getCarSpaces());
    }
    
    @Test 
    void setCarSpaces(){
        Property c1 = new ForSaleProperty("Room406","2 Bourke Street Melbourne","Docklands",2,3,2,"Apartment");
        c1.setCarSpaces(2);
        System.out.println(c1.SetCarSpaces());
    }
}
