package engine;

import java.util.Scanner;
import engine.PropertyManager;
import counts.Count;
import enums.PropertyListType;
import engine.UserManager;
import user.Employee;

public class Main {



    public static void main(String[] args) {

        /*PropertyManager propertymanager = new PropertyManager();
        propertymanager.createProperty(PropertyListType.FOR_SALE, "lon st", "mel", 5, 6, 4, "room");
        propertymanager.createProperty(PropertyListType.RENTAL, "king st", "mel", 5, 6, 4, "room");
        propertymanager.createProperty(PropertyListType.RENTAL, "lon st", "mel", 5, 6, 4, "room");
        System.out.println("ForSale" + Count.getCount("src\\csv\\IdCounts\\pendingForSaleCount.txt"));
        System.out.println("Rental" + Count.getCount("src\\csv\\IdCounts\\pendingRentalCount.txt"));

        System.out.println("Approved");
        System.out.println("ForSale" + Count.getCount("src\\csv\\IdCounts\\approvedForSaleCount.txt"));
        System.out.println("Rental" + Count.getCount("src\\csv\\IdCounts\\approvedRentalCount.txt"));
        propertymanager.approveProperty("PR1");
        propertymanager.approveProperty("PR0");
        propertymanager.approveProperty("PS0");
        System.out.println("ForSale" + Count.getCount("src\\csv\\IdCounts\\approvedForSaleCount.txt"));
        System.out.println("Rental" + Count.getCount("src\\csv\\IdCounts\\approvedRentalCount.txt"));*/
//        System.out.println("hi" == "hi");
//        System.out.println(String.format("%s%d", "hi", 5));
//        String s = "hi, me";
//        s = s.replaceFirst("hi", "me");
//        System.out.println(s);
        UserManager userManager = new UserManager();
        Employee employee1 = new Employee("Kristen", "123456", "kristen@hotmail.co.uk");
        Employee employee2 = new Employee("Harry", "123456", "Harry@gmail.com");
        Employee employee3 = new Employee("Chinguun", "123456", "chinguun@gmail.com");
        System.out.println(Count.getCount("src\\csv\\IdCounts\\employeeCount.txt") + "\n");
        userManager.createEmployee(employee1);
        userManager.createEmployee(employee2);
        userManager.createEmployee(employee3);
        System.out.println(Count.getCount("src\\csv\\IdCounts\\employeeCount.txt"));
    }



    private static void logIn()
    {
        Scanner scanner = new Scanner(System.in);
        String optionlog;
        System.out.println("Starting real estate manager start up...");
        System.out.println("Are you a: ");
        System.out.println("A. Customer");
        System.out.println("B: Employee");
        optionlog = scanner.next();
        if (optionlog.equals("A")){
            String enteredUserName;
            String enteredPassword;
            System.out.println("Starting real estate manager start up...");
            System.out.println("Please enter your username...");
            enteredUserName = scanner.next();
            System.out.println("Please enter your password...");
            enteredPassword = scanner.next();
        }else if (optionlog.equals("B")){
            String enteredUserName;
            String enteredPassword;
            System.out.println("Starting real estate manager start up...");
            System.out.println("Please enter your username...");
            enteredUserName = scanner.next();
            System.out.println("Please enter your password...");
            enteredPassword = scanner.next();
        }

    }
}
