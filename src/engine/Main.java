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








}
