package systemManagers;

import alertSystem.AlertEngine;
import enums.AlertType;
import inspections.Inspection;
import user.User;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

public class InspectionManager {
    Scan scan = new Scan();
    FileHandler fileHandler = new FileHandler();
    PropertyManager propertyManager;
    User user;
    AlertEngine alertEngine = new AlertEngine();
    public InspectionManager(PropertyManager propertyManager, User currentUser)
    {

        this.propertyManager = propertyManager;
        this.user = currentUser;
    }

    private void createInspection(User currentUser)
    {
        String idOfPropertyToBeInspected = scan.askForString("\n---------------------------\nWhat is " +
                "the ID of the property that you wish to list for inspection?\n");
        String dateTimeOfInspection = scan.askForString("What is the date and time for the inspection? (MM/HH/DD/MM/YYYY)");
        Inspection inspection = new Inspection(propertyManager.getPropertyAsObject(idOfPropertyToBeInspected, "approved"), dateTimeOfInspection);
        AlertType alertType = AlertType.INSPECTION_CREATED;
        alertEngine.inspectionAnnounced(inspection, alertType);
        saveInspectionToFile(inspection);


    }

    private void deleteInspection()
    {
        String idOfInspectionToBeDeleted = scan.askForString("\n-----------------------\nWhat is the id of the inspection " +
                "you wish to delete?\n");
        fileHandler.delete(idOfInspectionToBeDeleted, "src\\main\\java\\csv\\inspection\\inspection.csv");
        alertEngine.inspectionCancelled();
    }

    private void saveInspectionToFile(Inspection inspection) {
        FileHandler.writeToFile(inspection.toCsvFormat(), "src\\main\\java\\csv\\inspection\\inspection.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\inspection\\inspection.csv", true);
    }




}
