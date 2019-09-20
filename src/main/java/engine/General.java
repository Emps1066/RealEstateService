package engine;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class General {


    public void printCSVToTerminal(String fileAddress)
    {
        try{
            CSVReader reader = new CSVReader(new FileReader(fileAddress));

            for(String[] row : reader) {
                System.out.println(Arrays.toString(row));
            }
        }
        catch (IOException ioException)
        {
            System.out.println(fileAddress + " not found");
        }
    }


}
