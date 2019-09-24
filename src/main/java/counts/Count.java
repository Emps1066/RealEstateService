package counts;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Count {
    public static int getCount(String path) {
        int count = -1;
        try {
            Scanner countScanner = new Scanner(new File(path));
            count = countScanner.nextInt();

        } catch(FileNotFoundException e) {
            System.err.println(String.format("Error could not find %s", path));
        }
        return count;
    }

    public static void incrementCount(String path) {
        try {
            int count = getCount(path);
            FileWriter countFile = new FileWriter(path);
            count++;
            countFile.append(String.format("%d", count));
            countFile.close();
        } catch(IOException e) {
            System.err.println(String.format("Error writing to %s", path));
        }
    }
}



