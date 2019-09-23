package engine;

import counts.Count;
import scanner.Scan;
import enums.PropertyListType;
import fileHandler.FileHandler;

public class PropertyManager {

//    public void requestPropertyDetails() {
//
//        String address = Scan.askForString("Address");
//        String suburb = Scan.askForString("Suburb");
//        int bedrooms = Scan.askForInt("bedrooms");
//        int bathrooms = Scan.askForInt("bathrooms");
//        int carSpaces = Scan.askForInt("car spaces");
//        String type = Scan.askForString("Type");
//        String listType = Scan.askForString("ListType");
//        createProperty(listType.equals("Rental") ? PropertyListType.RENTAL : PropertyListType.FOR_SALE, address, suburb, bedrooms, bathrooms, carSpaces, type);
//    }

    //listType Rental/ForSale
    public void createProperty(PropertyListType listType, String address, String suburb, int bedrooms,
                               int bathrooms, int carSpaces, String type) {
        String IdSerial = listType.pendingIdSerial();
        String Id = String.format("%s%d", IdSerial, Count.getCount("src\\main\\java\\csv\\IdCounts\\pending" + listType + "Count.csv"));
        String pendingProperty = String.format("%s,%s,%s,%d,%d,%d,%s", Id, address, suburb, bedrooms, bathrooms, carSpaces, type);
        FileHandler.writeToFile(pendingProperty, "src\\main\\java\\csv\\properties\\pending" + listType + "Properties.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\properties\\pending" + listType + "Properties.csv", true);
        Count.incrementCount("src\\main\\java\\csv\\IdCounts\\pending" + listType + "Count.csv");
    }

    public boolean approveProperty(String Id) {

        boolean approved = false;
        PropertyListType listType = null;

        if(Id.contains(PropertyListType.RENTAL.pendingIdSerial())) {
            listType = PropertyListType.RENTAL;
        } else if(Id.contains(PropertyListType.FOR_SALE.pendingIdSerial())) {
            listType = PropertyListType.FOR_SALE;
        }

        String approvedProperty;
        String newId;
        String IdSerial = listType.IdSerial();
        if(listType != null) {
            approvedProperty = FileHandler.get(Id, 0,"src\\main\\java\\csv\\properties\\pending" + listType + "Properties.csv");
            FileHandler.delete(Id, "src\\main\\java\\csv\\properties\\pending" + listType + "Properties.csv");
            if(approvedProperty != null) {
                newId = String.format("%s%d", IdSerial, Count.getCount("src\\main\\java\\csv\\IdCounts\\approved" + listType + "Count.csv"));
                approvedProperty = approvedProperty.replaceFirst(Id, newId);
                FileHandler.writeToFile(approvedProperty + "\n","src\\main\\java\\csv\\properties\\approved" + listType + "Properties.csv", true);
                Count.incrementCount("src\\main\\java\\csv\\IdCounts\\approved" + listType + "Count.csv");
                approved = true;
            }
        }
        return approved;
    }

    public void printPropertiesCSVS(String file)
    {
        String fileAddress = "src\\main\\java\\csv\\properties\\" + file;
        General general = new General();
        general.printCSVToTerminal(fileAddress);

    }


}