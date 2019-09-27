package utilities.fileHandler;

import java.io.*;

public class FileHandler {
    public static String get(String uniqueString, int uniqueIndex, String file) {
        String rowToGet = null;
        boolean found = false;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null && !found) {
                String rowArray[] = row.split(",");
                if(rowArray[uniqueIndex].equals(uniqueString)) {
                    rowToGet = row;
                    found = true;
                }
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }
        return rowToGet;
    }

    public static void delete(String Id, String file) {
        String newFileText = "";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                if(!row.startsWith(Id)) {
                    newFileText += row;
                    newFileText += "\n";
                }
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        writeToFile(newFileText, file, false);
    }

    public static void writeToFile(String data, String file, boolean append) {
        try {
            FileWriter newPendingPropertyFile = new FileWriter(file, append);
            newPendingPropertyFile.append(data);
            newPendingPropertyFile.close();
        } catch(IOException e) {
            System.err.printf("Error writing to %s\n", file);
        }
    }
}
