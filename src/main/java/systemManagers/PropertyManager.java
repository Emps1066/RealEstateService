package systemManagers;

import enums.PropertyListType;
import utilities.fileHandler.FileHandler;
import property.Property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyManager
{

    private Map<String, Property> approvedProperties = new HashMap<>();
    private Map<String, Property> pendingProperties = new HashMap<>();
    private Map<String, Property> underContractProperties = new HashMap<>();

    public void addProperty(Property property)
    {
        String IdSerial = property.listType().pendingIdSerial();
        String Id = IdManager.generateUniqueID(IdSerial, "pending" + property.listType());
        property.setID(Id);
        pendingProperties.put(Id, property);
        IdManager.updateUniqueIdValue("pending" + property.listType());
    }

    public boolean approveProperty(String propertyId, String employeeId)
    {

        boolean approved = false;
        Property propertyToBeApproved = pendingProperties.remove(propertyId);

        if(propertyToBeApproved != null) {
            // Assign employee and new Id
            String newId = IdManager.generateUniqueID(propertyToBeApproved.listType().IdSerial(),
                    "approved" + propertyToBeApproved.listType());

            propertyToBeApproved.setID(newId);
            propertyToBeApproved.setEmployee(employeeId);
            approvedProperties.put(newId, propertyToBeApproved);
            IdManager.updateUniqueIdValue("approved" + propertyToBeApproved.listType());
            approved = true;
        }
        return approved;
    }

    public boolean SetPropertyUnderContract(String propertyId) {
        boolean underContract = false;
        Property propertyToBeUnderContract = approvedProperties.remove(propertyId);

        if(propertyToBeUnderContract != null) {
            // Assign new Id
            String newId = IdManager.generateUniqueID(propertyToBeUnderContract.listType().underContractIdSerial(),
                    "underContract" + propertyToBeUnderContract.listType());

            propertyToBeUnderContract.setID(newId);
            underContractProperties.put(newId, propertyToBeUnderContract);
            IdManager.updateUniqueIdValue("underContract" + propertyToBeUnderContract.listType());
            underContract = true;
        }
        return underContract;
    }

    public String propertiesToString(PropertyListType listType)
    {
        StringBuilder string = new StringBuilder();
        for(Property property : approvedProperties.values()) {
            if(property.listType() == listType && property.isListed()) {
                string.append(property.toListFormat());
                string.append("\n");
            }
        }
        string.deleteCharAt(string.length() - 1);
        return string.toString();
    }

    public String preferencePropertiesToString(List<String> suburbs)
    {
        StringBuilder string = new StringBuilder();
        for(Property property : approvedProperties.values()) {
            if(suburbs.contains(property.getSuburb())) {
                string.append(property.toListFormat());
                string.append("\n");
            }
        }
        string.deleteCharAt(string.length() - 1);
        return string.toString();
    }

    private void uploadToSystem() {
        discardFileContent("approvedRental");
        discardFileContent("approvedForSale");
        for(Property property : approvedProperties.values()) {
            savePropertyToFile(property.toCsvFormat(), "approved" + property.listType());
        }
        discardFileContent("pendingRental");
        discardFileContent("pendingForSale");
        for(Property property : pendingProperties.values()) {
            savePropertyToFile(property.toCsvFormat(), "pending" + property.listType());
        }
        discardFileContent("underContractRental");
        discardFileContent("underContractForSale");
        for(Property property : underContractProperties.values()) {
            savePropertyToFile(property.toCsvFormat(), "underContract" + property.listType());
        }
    }

    private void discardFileContent(String file) {
        FileHandler.writeToFile("", "src\\main\\java\\csv\\properties\\" + file + "Properties.csv", false);
    }

    private void savePropertyToFile(String data, String file)
    {
        FileHandler.writeToFile(data ,"src\\main\\java\\csv\\properties\\" + file + "Properties.csv", true);
        FileHandler.writeToFile("\n" ,"src\\main\\java\\csv\\properties\\" + file + "Properties.csv", true);
    }
}