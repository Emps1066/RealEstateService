package engine;

import user.Customer;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Customer customer = new Customer("Harry", "Hello", "harryluke@hotmail.com", "123", "41 Mills St Hampton");
        System.out.println("Do you want to...");
        System.out.println("A. log in.");
        System.out.println("B. create a profile.");
        System.out.println("C. Send an alert");

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
