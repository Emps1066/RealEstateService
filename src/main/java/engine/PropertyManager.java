package engine;

import idManager.IdManager;
import enums.PropertyListType;
import fileHandler.FileHandler;
import property.Property;

public class PropertyManager
{

    public void createProperty(Property property, PropertyListType listType)
    {
        String IdSerial = listType.pendingIdSerial();
        String Id = IdManager.generateUniqueID(IdSerial, "pending" + listType);
        property.setID(Id);
        String pendingProperty = property.toCsvFormat();
        savePropertyToFile(pendingProperty, "pending" + listType);
    }

    public boolean approveProperty(String propertyId, String employeeId)
    {

        boolean approved = false;
        PropertyListType listType = null;

        if(propertyId.contains(PropertyListType.RENTAL.pendingIdSerial()))
        {
            listType = PropertyListType.RENTAL;
        } else if(propertyId.contains(PropertyListType.FOR_SALE.pendingIdSerial()))
        {
            listType = PropertyListType.FOR_SALE;
        }

        String approvedProperty;
        String newId;
        String IdSerial = listType.IdSerial();
        if(listType != null)
        {
            approvedProperty = FileHandler.get(propertyId, 0,"src\\main\\java\\csv\\properties\\pending" + listType + "Properties.csv");
            FileHandler.delete(propertyId, "src\\main\\java\\csv\\properties\\pending" + listType + "Properties.csv");
            if(approvedProperty != null)
            {
                newId = IdManager.generateUniqueID(listType.IdSerial(), "approved" + listType);
                approvedProperty = approvedProperty.replaceFirst(propertyId, newId);
                String propertyDetails[] = approvedProperty.split(",");
                propertyDetails[propertyDetails.length - 1] = employeeId;
                approvedProperty = String.join(",", propertyDetails);
                savePropertyToFile(approvedProperty, "approved" + listType);
                approved = true;
            }
        }
        return approved;
    }

    public void printPropertiesCsv(String file)
    {
        String fileAddress = "src\\main\\java\\csv\\properties\\" + file + "Properties.csv";
    }

    private void savePropertyToFile(String data, String file)
    {
        FileHandler.writeToFile(data ,"src\\main\\java\\csv\\properties\\" + file + "Properties.csv", true);
        FileHandler.writeToFile("\n" ,"src\\main\\java\\csv\\properties\\" + file + "Properties.csv", true);
        IdManager.updateUniqueIdValue(file);
    }
}