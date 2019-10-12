package systemManagers;

import enums.PropertyListType;
import property.ForSaleProperty;
import property.RentalProperty;
import utilities.fileHandler.FileHandler;
import property.Property;
import utilities.scanner.Scan;

import java.util.*;

public class PropertyManager {

    private static final int NUM_OF_PREFERRED_CONTRACT_DURATIONS = 3;
    private Map<String, Property> approvedProperties;
    private Map<String, Property> pendingProperties;
    private Map<String, Property> underContractProperties;

    public PropertyManager(Map<String, Property> approvedProperties,
                           Map<String, Property> pendingProperties,
                           Map<String, Property> underContractProperties) {
        this.approvedProperties = approvedProperties;
        this.pendingProperties = pendingProperties;
        this.underContractProperties = underContractProperties;
    }


    public Property getPropertyAsObject(String propertyId, String type) {

        Property propertyToReturn = null;
        if (type == "approved") {
            propertyToReturn = approvedProperties.get(propertyId);
        }
        if (type == "pending") {
            propertyToReturn = pendingProperties.get(propertyId);
        } else {
            propertyToReturn = underContractProperties.get(propertyId);
        }

        return propertyToReturn;
    }

    public Property askForPropertyDetails(String ownerId, PropertyListType listType) {
        String address = Scan.askForString("Enter Your Property's Address:");
        String suburb = Scan.askForString("Enter Your Property's Suburb:");
        int bedrooms = Scan.askForInt("Enter The Number Of Bedrooms In Your Property:");
        int bathrooms = Scan.askForInt("Enter The Number Of Bathrooms In Your Property:");
        int carSpaces = Scan.askForInt("Enter The Number Of Car Spaces In Your Property:");
        String type = Scan.askForString("Enter The Type Of Your Property (Apartment, House, Studio, Room etc):");

        Property property;
        if (listType == PropertyListType.FOR_SALE) {
            double minimumPrice = Scan.askForDouble("Enter Your Base For Sale Price:");

            property = new ForSaleProperty(null, address, suburb, bedrooms, bathrooms, carSpaces, type, ownerId, minimumPrice);
        } else {
            double rentPrice = Scan.askForDouble("Enter Your Base Rental Price:");
            double contractDuration[] = new double[NUM_OF_PREFERRED_CONTRACT_DURATIONS];
            for (int loop = 0; loop < NUM_OF_PREFERRED_CONTRACT_DURATIONS; ++loop) {
                String ordinalAbbreviation;
                if (loop == 0) {
                    ordinalAbbreviation = "st";
                } else if (loop == 1) {
                    ordinalAbbreviation = "nd";
                } else if (loop == 2) {
                    ordinalAbbreviation = "rd";
                } else {
                    ordinalAbbreviation = "th";
                }
                contractDuration[loop] = Scan.askForDouble("Enter Your " +
                        (loop + 1) + ordinalAbbreviation + " Preferred Contract Duration:");
            }

            property = new RentalProperty(null, address, suburb, bedrooms, bathrooms, carSpaces,
                    type, ownerId, contractDuration[0], contractDuration[1], contractDuration[2], rentPrice);
        }

        return property;
    }

    public void addProperty(Property property) {
        String IdSerial = property.listType().pendingIdSerial();
        String Id = IdManager.generateUniqueID(IdSerial, "pending" + property.listType());
        property.setID(Id);
        pendingProperties.put(Id, property);
        IdManager.updateUniqueIdValue("pending" + property.listType());
        System.out.println("Pending property added");
    }

    public boolean approveProperty(String propertyId, String employeeId) {

        boolean approved = false;
        Property propertyToBeApproved = pendingProperties.remove(propertyId);

        if (propertyToBeApproved != null) {
            // Assign employee and new Id
            String newId = IdManager.generateUniqueID(propertyToBeApproved.listType().IdSerial(),
                    "approved" + propertyToBeApproved.listType());

            propertyToBeApproved.setID(newId);
            propertyToBeApproved.setEmployee(employeeId);
            approvedProperties.put(newId, propertyToBeApproved);
            IdManager.updateUniqueIdValue("approved" + propertyToBeApproved.listType());
            approved = true;
            System.out.println("Property approved");
        } else {
            System.out.println("Property does not exist");
        }
        return approved;
    }

    public boolean setPropertyUnderContract(String propertyId, String buyerOrRenter) {
        boolean underContract = false;
        Property propertyToBeUnderContract = approvedProperties.remove(propertyId);
        propertyToBeUnderContract.setListed(false);
        if (propertyToBeUnderContract != null) {
            // Assign new Id
            String newId = IdManager.generateUniqueID(propertyToBeUnderContract.listType().underContractIdSerial(),
                    "underContract" + propertyToBeUnderContract.listType());

            propertyToBeUnderContract.setID(newId);
            underContractProperties.put(newId, propertyToBeUnderContract);
            IdManager.updateUniqueIdValue("underContract" + propertyToBeUnderContract.listType());

            if (propertyToBeUnderContract.listType() == PropertyListType.FOR_SALE) {
                ((ForSaleProperty) propertyToBeUnderContract).setBuyerId(buyerOrRenter);
            } else {
                ((RentalProperty) propertyToBeUnderContract).setRenterId(buyerOrRenter);
            }

            underContract = true;
        }
        return underContract;
    }

    public String getPropertyOwnerId(String propertyId) {
        String propertyOwnerId = null;
        for (Property property : approvedProperties.values()) {
            if (property.getID().equals(propertyId)) {
                propertyOwnerId = property.getOwnerCustomer();
            }
        }

        return propertyOwnerId;
    }

    public boolean propertyExistsAsListed(String propertyId, PropertyListType listType) {
        boolean exists = false;
        for (Property property : getListedProperties()) {
            if (property.getID().equals(propertyId) && property.listType() == listType) {
                exists = true;
            }
        }

        return exists;
    }

    public void unlistProperty(String propertyId) {
        for (Property property : getListedProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setListed(false);
            }
        }
    }

    public void listProperty(String propertyId) {
        for (Property property : getListedProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setListed(true);
            }
        }
    }

    public List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();
        properties.addAll(approvedProperties.values());
        properties.addAll(pendingProperties.values());
        properties.addAll(underContractProperties.values());

        return properties;
    }

    public List<Property> getListedProperties() {
        List<Property> listedProperties = new ArrayList<>();
        for (Property property : approvedProperties.values()) {
            if (property.isListed()) {
                listedProperties.add(property);
            }
        }
        return listedProperties;
    }

    public String listedPropertiesToString(PropertyListType listType) {
        StringBuilder string = new StringBuilder();
        for (Property property : getListedProperties()) {
            if (property.listType() == listType && property.isListed()) {
                string.append(property.toListFormat());
                string.append("\n");
            }
        }
        if (!string.toString().equals("")) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }

    public String preferencePropertiesToString(List<String> suburbs) {
        StringBuilder string = new StringBuilder();
        for (Property property : getListedProperties()) {
            if (suburbs.contains(property.getSuburb())) {
                string.append(property.toListFormat());
                string.append("\n");
            }
        }
        if (!string.toString().equals("")) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }

    public String myPropertiesToString(String ownerId) {
        StringBuilder propertiesList = new StringBuilder();

        for (Property property : getAllProperties()) {
            if (property.getOwnerCustomer().equals(ownerId)) {
                propertiesList.append(property.toListFormat());
                propertiesList.append("\n");
            }
        }
        if (!propertiesList.toString().equals("")) {
            propertiesList.deleteCharAt(propertiesList.length() - 1);
        }

        return propertiesList.toString();
    }

    public String getMyPropertyToEdit(String propertyId, String ownerId) {
        StringBuilder propertyString = new StringBuilder();
        Property property = approvedProperties.get(propertyId);
        if (property == null) {
            pendingProperties.get(propertyId);
        }
        if (property != null && property.getOwnerCustomer().equals(ownerId)) {
            propertyString.append(property.toListFormat());
        }

        return propertyString.toString();
    }

    public void editAddress(String propertyId, String address) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setAddress(address);
            }
        }
    }

    public void editSuburb(String propertyId, String suburb) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setSuburb(suburb);
            }
        }
    }

    public void editNumberOfBedrooms(String propertyId, int bedrooms) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setBedrooms(bedrooms);
            }
        }
    }

    public void editNumberOfBathrooms(String propertyId, int bathrooms) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setBathrooms(bathrooms);
            }
        }
    }

    public void editNumberOfCarSpaces(String propertyId, int carSpaces) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setCarSpaces(carSpaces);
            }
        }
    }

    public void editPropertyType(String propertyId, String type) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                property.setType(type);
            }
        }
    }

    public void editPricing(String propertyId, double price) {
        for (Property property : getAllProperties()) {
            if (property.getID().equals(propertyId)) {
                if (property.listType() == PropertyListType.RENTAL) {
                    ((RentalProperty) property).setRentPrice(price);
                } else if (property.listType() == PropertyListType.FOR_SALE) {
                    ((ForSaleProperty) property).setPrice(price);
                }
            }
        }
    }

    public void saveToSystem() {
        discardFileContent("approvedRental");
        discardFileContent("approvedForSale");
        for (Property property : approvedProperties.values()) {
            savePropertyToFile(property.toCsvFormat(), "approved" + property.listType());
        }
        discardFileContent("pendingRental");
        discardFileContent("pendingForSale");
        for (Property property : pendingProperties.values()) {
            savePropertyToFile(property.toCsvFormat(), "pending" + property.listType());
        }
        discardFileContent("underContractRental");
        discardFileContent("underContractForSale");
        for (Property property : underContractProperties.values()) {
            savePropertyToFile(property.toCsvFormat(), "underContract" + property.listType());
        }
    }

    private void discardFileContent(String file) {
        FileHandler.writeToFile("", "src\\main\\java\\csv\\properties\\" + file + "Properties.csv", false);
    }

    private void savePropertyToFile(String data, String file) {
        FileHandler.writeToFile(data, "src\\main\\java\\csv\\properties\\" + file + "Properties.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\properties\\" + file + "Properties.csv", true);
    }
}