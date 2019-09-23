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
                System.out.printf("Invalid input type please try again");
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

    public static int askForOption(int numberOfOptions, String optionMenu) { return askForOption(numberOfOptions, optionMenu, new Scanner(System.in)); }

    public static int askForOption(int numberOfOptions, String optionMenu, Scanner scanner) {
        int optionsArray[] = new int[numberOfOptions];
        for(int initial = 0; initial < numberOfOptions; ++initial) {
            optionsArray[initial] = initial + 1;
        }

        int option = 0;
        boolean validOption = false;
        while(!validOption) {
            System.out.println(optionMenu);
            option = Scan.askForIntInput();

            for(int chosenOption : optionsArray) {
                if(chosenOption == option) {
                    validOption = true;
                }
            }

            if(!validOption) {
                System.out.println("Unavailable option please choose one of:");
                for(int loop = 0; loop < optionsArray.length; loop++) {
                    if(loop == optionsArray.length - 1) {
                        System.out.printf(" or ");
                    } else if(loop != 0) {
                        System.out.printf(", ");
                    }
                    System.out.printf("%d", optionsArray[loop]);
                }
                System.out.printf("\n");
            }
        }
        return option;
    }

    public static int askForIntInput() { return askForIntInput(new Scanner(System.in));  }

    public static int askForIntInput(Scanner scanner) {
        int num = 0;
        boolean doAgain = true;
        while(doAgain) {
            System.out.printf("> ");
            if(scanner.hasNextInt()) {
                num = scanner.nextInt();
                doAgain = false;
            } else {
                System.out.println("Invalid input type please try again");
                scanner.nextLine();
            }
        }
        return num;
    }

}