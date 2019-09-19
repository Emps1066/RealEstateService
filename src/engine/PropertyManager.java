package engine;


import counts.Count;
import scanner.Scan;
import enums.PropertyListType;
import fileHandler.FileHandler;


public class PropertyManager {

    public void requestPropertyDetails() {

        String address = Scan.askForString("Address");
        String suburb = Scan.askForString("Suburb");
        int bedrooms = Scan.askForInt("bedrooms");
        int bathrooms = Scan.askForInt("bathrooms");
        int carSpaces = Scan.askForInt("car spaces");
        String type = Scan.askForString("Type");
        String listType = Scan.askForString("ListType");
        createProperty(listType.equals("Rental") ? PropertyListType.RENTAL : PropertyListType.FOR_SALE, address, suburb, bedrooms, bathrooms, carSpaces, type);
    }

    //listType Rental/ForSale
    public void createProperty(PropertyListType listType, String address, String suburb, int bedrooms,
                               int bathrooms, int carSpaces, String type) {
        String IdSerial = listType == PropertyListType.RENTAL ? "PR" : "PS";
        String Id = String.format("%s%d", IdSerial, Count.getCount("src\\csv\\IdCounts\\pending" + listType + "Count.txt"));
        String pendingProperty = String.format("%s, %s, %s, %d, %d, %d, %s", Id, address, suburb, bedrooms, bathrooms, carSpaces, type);
        FileHandler.writeToFile(pendingProperty, "src\\csv\\properties\\pending" + listType + "Properties.txt", true);
        FileHandler.writeToFile("\n", "src\\csv\\properties\\pending" + listType + "Properties.txt", true);
        Count.incrementCount("src\\csv\\IdCounts\\pending" + listType + "Count.txt");
    }

    public boolean approveProperty(String Id) {
        boolean approved = false;
        PropertyListType listType = null;
        String IdSerial = null;
        if(Id.contains("PR")) {
            listType = PropertyListType.RENTAL;
            IdSerial = "R";
        } else if(Id.contains("PS")) {
            listType = PropertyListType.FOR_SALE;
            IdSerial = "S";
        }

        String approvedProperty;
        String newId;
        if(listType != null) {
            approvedProperty = FileHandler.get(Id, "src\\csv\\properties\\pending" + listType + "Properties.txt");
            FileHandler.delete(Id, "src\\csv\\properties\\pending" + listType + "Properties.txt");
            if(approvedProperty != null) {
                newId = String.format("%s%d", IdSerial, Count.getCount("src\\csv\\IdCounts\\approved" + listType + "Count.txt"));
                approvedProperty = approvedProperty.replaceFirst(Id, newId);
                FileHandler.writeToFile(approvedProperty + "\n","src\\csv\\properties\\approved" + listType + "Properties.txt", true);
                Count.incrementCount("src\\csv\\IdCounts\\approved" + listType + "Count.txt");
                approved = true;
            }
        }
        return approved;
    }

}