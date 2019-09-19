package engine;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option;
        System.out.println("Do you want to...");
        System.out.println("A. log in.");
        System.out.println("B. create a profile.");
        option = scanner.nextLine();
        if (option.equals("A")){
            logIn();
        }


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
