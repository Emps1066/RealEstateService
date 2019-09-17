package scanner;

import java.util.Scanner;

public class Scan {
    public static int askForInt(String text) {
        return askForInt(text, new Scanner(System.in));
    }

    public static int askForInt(String text, Scanner scanner) {
        int num = 0;
        boolean doAgain = true;
        while(doAgain) {
            System.out.printf("Enter number of %s:", text);
            if(scanner.hasNextInt()) {
                num = scanner.nextInt();
                doAgain = false;
            } else {
                System.out.printf("Invalid input type please try again\n");
                scanner.nextLine();
            }
        }
        return num;
    }

    public static String askForString(String text) {
        return (askForString(text, new Scanner(System.in)));
    }

    public static String askForString(String text, Scanner scanner) {
        String string;
        System.out.printf("Enter %s:", text);
        string = scanner.nextLine();
        return string;
    }
}