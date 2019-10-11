package systemManagers;

import inspections.Inspection;
import user.User;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

public class InspectionManager {
    Scan scan = new Scan();
    FileHandler fileHandler = new FileHandler();

    private void createInspection(User currentUser)
    {
        String idOfPropertyToBeInspected = scan.askForString("\n---------------------------\nWhat is " +
                "the ID of the property that you wish to list?\n");
        String dateTimeOfInspection = scan.askForString("What is the date and time for the inspection? (MM/HH/DD/MM/YYYY)");
        Inspection inspection = new Inspection(idOfPropertyToBeInspected, dateTimeOfInspection);
        saveInspectionToFile(inspection);


    }

    private void deleteInspection()
    {
        String idOfInspectionToBeDeleted = scan.askForString("\n-----------------------\nWhat is the id of the inspection " +
                "you wish to delete?\n");
        fileHandler.delete(idOfInspectionToBeDeleted, "src\\main\\java\\csv\\inspection\\inspection.csv");
    }

    private void saveInspectionToFile(Inspection inspection) {
        FileHandler.writeToFile(inspection.toCsvFormat(), "src\\main\\java\\csv\\inspection\\inspection.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\inspection\\inspection.csv", true);
    }


}
