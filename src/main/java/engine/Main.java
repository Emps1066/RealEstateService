package engine;

import alertSystem.MailSystemTLS;
import scanner.Scan;
import user.Customer;

import java.util.Properties;
import java.util.Scanner;

import engine.PropertyManager;
import counts.Count;
import enums.PropertyListType;
import engine.UserManager;
import user.Employee;
import user.User;

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
        System.out.println("Rental" + Count.getCount("src\\csv\\IdCounts\\approvedRentalCount.txt"));
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
        */
        PropertyManager propertyManager = new PropertyManager();
        String fileName = null;
        Boolean systemActive = true;
        String choice = null;
        MailSystemTLS mailSystemTLS = new MailSystemTLS();
        UserManager userManager = new UserManager();
        User currentUser;

        choice = Scan.askForString("Hi there, would you like to log in, or make a new account? (A = log in, B = create new account, C = continue as non-user");
        mailSystemTLS.sendEmail();

        if (choice.equals("A")) {
            logIn();
        }

        if (choice.equals("B")) {
            userManager.createUser();
        }

        if (choice.equals("C")) {

        }


        while (systemActive) {
            choice = Scan.askForString("What would you like to do? Enter a letter to choose. A = create a property to be approved, B = Approve a property, L = log out,  P = close system");
            System.out.println(choice);
            if (choice.equals("A")) {
                propertyManager.requestPropertyDetails();
            } else if (choice.equals("B")) {
                choice = Scan.askForString("Would you like to approve a forSale property? Or a rentalProperty? A = forSale B = rentalProperty, C = approve employee");
                if (choice.equals("A")) {
                    fileName = "pendingForSaleProperties.CSV";

                }

                if (choice.equals("B")) {
                    fileName = "pendingRentalProperties.CSV";
                }
                propertyManager.printPropertiesCSVS(fileName);
                propertyManager.approveProperty(Scan.askForString("Which ID should we approve?"));
            }

            else if(choice.equals("C"))
            {
                //TODO print out all applying employees, design approval method
            }

            else if (choice.equals("L")) {
                currentUser = null;
            } else if (choice.equals("P")) {
                System.out.println("System shutting down...");
                systemActive = false;
            }

        }


    }


    private static void logIn() {
        Scanner scanner = new Scanner(System.in);
        String enteredUserName;
        String enteredPassword;
        String userType = null;
        String optionlog;
        System.out.println("Are you a: ");
        System.out.println("A. Customer");
        System.out.println("B: Employee");
        optionlog = Scan.askForString("");
        enteredUserName = Scan.askForString("Please enter your username...");
        enteredPassword = Scan.askForString("Please enter your password...");
        UserManager userManager = new UserManager();
        optionlog = scanner.next();
        if (optionlog.equals("A")) {
            userType = "customer";

        } else if (optionlog.equals("Customer")) {
            userType = "employee";
        }
        if (userManager.logInVerification(userType)) {
            //TODO init current user
        } else {
            System.out.println("Sorry, incorrect password or username...");
        }

    }
}
