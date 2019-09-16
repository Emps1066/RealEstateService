package engine;

import property.Property;
import property.RentalProperty;
import property.ForSaleProperty;
import scanner.Scan;

import java.io.FileWriter;
import java.io.IOException;

public class PropertyManager {
    private int numIDs = 0;


    public void requestProperyDetails() {
        String address = Scan.askForString("Address");
        String suburb = Scan.askForString("Suburb");
        int bedrooms = Scan.askForInt("bedrooms");
        int bathrooms = Scan.askForInt("bathrooms");
        int carSpaces = Scan.askForInt("car spaces");
        String type = Scan.askForString("Type");
        int listType = Scan.askForInt("ListType");
        createProperty(listType, address, suburb, bedrooms, bathrooms, carSpaces, type);
    }

    public void createProperty(int listType, String address, String suburb, int bedrooms,
                               int bathrooms, int carSpaces, String type) {
        String id = String.format("%d", numIDs);
        numIDs++;
        Property pendingProperty = null;
        if (listType == 0) {
            pendingProperty = new RentalProperty(id, address, suburb, bedrooms, bathrooms, carSpaces, type);
        } else if (listType == 1) {
            pendingProperty = new ForSaleProperty(id, address, suburb, bedrooms, bathrooms, carSpaces, type);
        }

        try {
            FileWriter pendingPropertyFile = new FileWriter("pendingProperties.txt", true);
            pendingPropertyFile.append(pendingProperty.toCSV());
            pendingPropertyFile.append("\n");
            pendingPropertyFile.flush();
            pendingPropertyFile.close();
        } catch (IOException ioe) {

        }
    }

}