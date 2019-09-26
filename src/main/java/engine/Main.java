package engine;

import user.User;
import property.*;
import account.Account;
import enums.PropertyListType;
import idManager.IdManager;
import menusForUsers.propertySeekaMenu.PropertySeekaMenu;

public class Main {


    public static void main(String[] args) {

//        PropertyManager propertymanager = new PropertyManager();
//        ForSaleProperty property1 = new ForSaleProperty(null, "lon st", "mel", 5, 6, 4, "room", null);
//        RentalProperty property2 = new RentalProperty(null, "king st", "mel", 5, 6, 4, "room", null);
//        RentalProperty property3 = new RentalProperty(null, "Salisbury st", "mel", 5, 6, 4, "room", null);
//        propertymanager.createProperty(property1,PropertyListType.FOR_SALE);
//        propertymanager.createProperty(property2,PropertyListType.RENTAL);
//        propertymanager.createProperty(property3,PropertyListType.RENTAL);
//        System.out.println("ForSale" + IdManager.getIdCount("pendingForSale"));
//        System.out.println("Rental" + IdManager.getIdCount("pendingRental"));
//
//        System.out.println("Approved");
//        System.out.println("ForSale" + IdManager.getIdCount("approvedForSale"));
//        System.out.println("Rental" + IdManager.getIdCount("approvedRental"));
//        propertymanager.approveProperty("PR1", "E1");
//        propertymanager.approveProperty("PR0", "E2");
//        propertymanager.approveProperty("PS0", "E3");
//        System.out.println("ForSale" + IdManager.getIdCount("approvedForSale"));
//        System.out.println("Rental" + IdManager.getIdCount("approvedRental"));
//        System.out.println("hi" == "hi");
//        System.out.println(String.format("%s%d", "hi", 5));
//        String s = "hi, me";
//        s = s.replaceFirst("hi", "me");
//        System.out.println(s);
//
//        UserManager userManager = new UserManager();
//        Employee employee1 = new Employee("Kristen", "123456", "kristen@hotmail.co.uk", "pass");
//        Employee employee2 = new Employee("Harry", "123456", "Harry@gmail.com", "pass");
//        Employee employee3 = new Employee("Chinguun", "123456", "chinguun@gmail.com", "pass");
//        System.out.println(IdManager.getCount("src\\main\\java\\csv\\IdCounts\\employeeCount.csv"));
//        userManager.createUser(employee1);
//        userManager.createUser(employee2);
//        userManager.createUser(employee3);
//        System.out.println(IdManager.getCount("src\\main\\java\\IdCounts\\employeeCount.csv"));

//        PropertyManager propertyManager = new PropertyManager();
//        String fileName = null;
//        Boolean systemActive = true;
//        String choice = null;
//        MailSystemTLS mailSystemTLS = new MailSystemTLS();
//        UserManager userManager = new UserManager();
//        User currentUser;
//
//        choice = Scan.askForString("Hi there, would you like to log in, or make a new account? (A = log in, B = create new account, C = continue as non-user");
//        mailSystemTLS.sendEmail();
//
//        if (choice.equals("A")) {
//            logIn();
//        }
//
//        if (choice.equals("B")) {
//            userManager.createUser();
//        }
//
//        if (choice.equals("C")) {
//
//        }
//
//
//        while (systemActive) {
//            choice = Scan.askForString("What would you like to do? Enter a letter to choose. A = create a property to be approved, B = Approve a property, L = log out,  P = close system");
//            System.out.println(choice);
//            if (choice.equals("A")) {
//                propertyManager.requestPropertyDetails();
//            } else if (choice.equals("B")) {
//                choice = Scan.askForString("Would you like to approve a forSale property? Or a rentalProperty? A = forSale B = rentalProperty, C = approve employee");
//                if (choice.equals("A")) {
//                    fileName = "pendingForSaleProperties.CSV";
//
//                }
//
//                if (choice.equals("B")) {
//                    fileName = "pendingRentalProperties.CSV";
//                }
//                propertyManager.printPropertiesCSVS(fileName);
//                propertyManager.approveProperty(Scan.askForString("Which ID should we approve?"));
//            }
//
//            else if(choice.equals("C"))
//            {
//                //TODO print out all applying employees, design approval method
//            }
//
//            else if (choice.equals("L")) {
//                currentUser = null;
//            } else if (choice.equals("P")) {
//                System.out.println("System shutting down...");
//                systemActive = false;
//            }
//
//        }
        Account account = new Account();
        User user = account.logUserIn();
        PropertySeekaMenu menu = new PropertySeekaMenu();
        menu.goToMainMenu();

//        System.out.println(user.toCsvString());
//        String email = Scan.askForString("your email");
//        email = email.toLowerCase();
//        System.out.println(email);

    }


//    private static void logIn() {
//        Scanner scanner = new Scanner(System.in);
//        String enteredUserName;
//        String enteredPassword;
//        String userType = null;
//        String optionlog;
//        System.out.println("Are you a: ");
//        System.out.println("A. Customer");
//        System.out.println("B: Employee");
//        optionlog = Scan.askForString("");
//        enteredUserName = Scan.askForString("Please enter your username...");
//        enteredPassword = Scan.askForString("Please enter your password...");
//        UserManager userManager = new UserManager();
//        optionlog = scanner.next();
//        if (optionlog.equals("A")) {
//            userType = "customer";
//
//        } else if (optionlog.equals("Customer")) {
//            userType = "employee";
//        }
//        if (userManager.logInVerification(userType)) {
//            //TODO init current user
//        } else {
//            System.out.println("Sorry, incorrect password or username...");
//        }
//
//    }
}
