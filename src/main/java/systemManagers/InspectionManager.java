package systemManagers;

import alertSystem.AlertEngine;
import enums.AlertType;
import inspections.Inspection;
import property.Property;
import user.User;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

import java.util.Map;

public class InspectionManager {
    Scan scan = new Scan();
    FileHandler fileHandler = new FileHandler();
    PropertyManager propertyManager;
    User user;
    AlertEngine alertEngine = new AlertEngine();
    private Map<String, Inspection> activeInspections;

    public InspectionManager(PropertyManager propertyManager, User currentUser) {

        this.propertyManager = propertyManager;
        this.user = currentUser;
    }


    private void createInspection(PropertyManager propertyManager) {
        String idOfPropertyToBeInspected = scan.askForString("\n---------------------------\nWhat is " +
                "the ID of the property that you wish to list for inspection?\n");
        String dateTimeOfInspection = scan.askForString("What is the date and time for the inspection? (MM/HH/DD/MM/YYYY)");
        Inspection inspection = new Inspection(IdManager.generateUniqueID("I", "inspectionCount" ), idOfPropertyToBeInspected, dateTimeOfInspection, propertyManager);
        AlertType alertType = AlertType.INSPECTION_CREATED;
        alertEngine.inspectionAlert(inspection, alertType);
        saveInspectionToFile(inspection);


    }

    private void cancelAllInspectionsOfAProperty(Property property)
    {
        for(Inspection inspection: activeInspections.values())
        {
            if(inspection.getInspectionProperty().getID() == property.getID())
            {
                fileHandler.delete(inspection.getInspectionId(), "src\\main\\java\\csv\\inspection\\inspection.csv");
            }
        }

    }

    private void cancelACertainInspection()
    {
        String idOfInspectionToBeDeleted = scan.askForString("\n-----------------------\nWhat is the id of the inspection " +
                "you wish to delete?\n");
        fileHandler.delete(idOfInspectionToBeDeleted, "src\\main\\java\\csv\\inspection\\inspection.csv");
        Inspection inspectionToDelete = activeInspections.get(idOfInspectionToBeDeleted);
        alertEngine.inspectionCancelled(inspectionToDelete);
    }


    private void saveInspectionToFile(Inspection inspection) {
        FileHandler.writeToFile(inspection.toCsvFormat(), "src\\main\\java\\csv\\inspection\\inspection.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\inspection\\inspection.csv", true);
    }

}
