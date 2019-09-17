package engine;

import counts.Count;
import scanner.Scan;


import java.io.*;

public class PropertyManager {

    public void requestPropertyDetails() {
        String address = Scan.askForString("Address");
        String suburb = Scan.askForString("Suburb");
        int bedrooms = Scan.askForInt("bedrooms");
        int bathrooms = Scan.askForInt("bathrooms");
        int carSpaces = Scan.askForInt("car spaces");
        String type = Scan.askForString("Type");
        String listType = Scan.askForString("ListType");
        createProperty(listType, address, suburb, bedrooms, bathrooms, carSpaces, type);
    }

    //listType Rental/ForSale
    public void createProperty(String listType, String address, String suburb, int bedrooms,
                               int bathrooms, int carSpaces, String type) {
        String IdSerial = null;
        if (listType.equals("Rental")) {
            IdSerial = "PR";
        } else if(listType.equals("ForSale")) {
            IdSerial = "PS";
        }

        String Id = String.format("%s%d", IdSerial, Count.getCount("src\\csv\\IdCounts\\pending" + listType + "Count.txt"));
        String pendingProperty = String.format("%s, %s, %s, %d, %d, %d, %s", Id, address, suburb, bedrooms, bathrooms, carSpaces, type);
        writeToFile(pendingProperty, "src\\csv\\properties\\pending" + listType + "Properties.txt", true);
        writeToFile("\n", "src\\csv\\properties\\pending" + listType + "Properties.txt", true);
        Count.incrementCount("src\\csv\\IdCounts\\pending" + listType + "Count.txt");
    }

    public boolean approveProperty(String Id) {
        boolean approved = false;
        String listType = null;
        String IdSerial = null;
        if(Id.contains("PR")) {
            listType = "Rental";
            IdSerial = "R";
        } else if(Id.contains("PS")) {
            listType = "ForSale";
            IdSerial = "S";
        }

        String approvedProperty;
        String newId;
        if(listType != null) {
            approvedProperty = findAndDelete(Id, "src\\csv\\properties\\pending" + listType + "Properties.txt");
            if(approvedProperty != null) {
                newId = String.format("%s%d", IdSerial, Count.getCount("src\\csv\\IdCounts\\approved" + listType + "Count.txt"));
                approvedProperty = approvedProperty.replaceFirst(Id, newId);
                writeToFile(approvedProperty,"src\\csv\\properties\\approved" + listType + "Properties.txt", true);
                writeToFile("\n", "src\\csv\\properties\\pending" + listType + "Properties.txt", true);
                Count.incrementCount("src\\csv\\IdCounts\\approved" + listType + "Count.txt");
                approved = true;
            }
        }
        return approved;
    }

    private String findAndDelete(String Id, String file) {
        String newFileText = "";
        String deletedRow = null;
        try {
            BufferedReader oldPendingPropertyFile = new BufferedReader(new FileReader(file));
            String row;
            while((row = oldPendingPropertyFile.readLine()) != null) {
                if(!row.startsWith(Id)) {
                    newFileText += row;
                    newFileText += "\n";
                } else {
                    deletedRow = row;
                }
            }
            oldPendingPropertyFile.close();
        } catch(FileNotFoundException e) {
            System.err.printf("Error could not find %s\n", file);
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        writeToFile(newFileText, file, false);
        return deletedRow;
    }

    private void writeToFile(String data, String file, boolean append) {
        try {
            FileWriter newPendingPropertyFile = new FileWriter(file, append);
            newPendingPropertyFile.append(data);
            newPendingPropertyFile.close();
        } catch(IOException e) {
            System.err.printf("Error writing to %s\n", file);
        }
    }
}