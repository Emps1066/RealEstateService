package engine;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        System.out.println("Do you want to...");
        System.out.println("A. log in.");
        System.out.println("B. create a profile.");

    }



    private static void logIn()
    {
        Scanner scanner = new Scanner(System.in);
        String enteredUserName;
        String enteredPassword;
        System.out.println("Starting real estate manager start up...");
        System.out.println("Please enter your username...");
        enteredUserName = scanner.next();
        System.out.println("Please enter your password...");
        enteredPassword = scanner.next();



    }

    private static void createUser()
    {
        int choice = 0;
        String username;
        String password;
        System.out.println("Are you an employee or a customer? (1 for employee, 2 for customer");
        System.out.println("What is your chosen username?");
        System.out.println("What is your chosen password");
        if(choice == 1)
        {
            System.out.println();
        }
        else{


        }
    }

    public void createCurrentUser()
    {

    }



}
