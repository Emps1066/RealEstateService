package idManager;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class IdManager {

    public static String generateUniqueID(String idSerial, String file)
    {
        return String.format("%s%d", idSerial, getIdCount(file));
    }

    public static void updateUniqueIdValue(String file) {
        incrementCount(file);
    }

    public static int getIdCount(String file) {
        int count = -1;
        try {
            Scanner countScanner = new Scanner(new File("src\\main\\java\\csv\\IdCounts\\" + file + "Count.csv"));
            count = countScanner.nextInt();

        } catch(FileNotFoundException e) {
            System.err.println(String.format("Error could not find %s", "src\\main\\java\\csv\\IdCounts\\" + file + "Count.csv"));
        }
        return count;
    }

    private static void incrementCount(String file) {
        try {
            int count = getIdCount(file);
            FileWriter countFile = new FileWriter("src\\main\\java\\csv\\IdCounts\\" + file + "Count.csv");
            count++;
            countFile.append(String.format("%d", count));
            countFile.close();
        } catch(IOException e) {
            System.err.println(String.format("Error writing to %s", "src\\main\\java\\csv\\IdCounts\\" + file + "Count.csv"));
        }
    }
}



