package inspections;

import property.Property;
import systemManagers.IdManager;
import systemManagers.PropertyManager;
import utilities.fileHandler.FileHandler;

public class Inspection {
    IdManager idManager = new IdManager();
    FileHandler fileHandler = new FileHandler();


    String inspectionId;
    String idOfPropertyToBeInspected;
    String inspectionTimeDate;
    String inspectionSuburb;
    String employeeId;
    Property inspectionProperty;
    public Inspection(Property property, String inspectionTimeDate)
    {
        this.inspectionProperty = property;
        this.inspectionSuburb = property.getSuburb();
        this.idOfPropertyToBeInspected = property.getID();
        this.inspectionTimeDate = inspectionTimeDate;
        this.employeeId = property.getEmployee();
        this.inspectionId =  idManager.generateUniqueID("I", "inspectionCount" );
    }

    public String getIdOfPropertyToBeInspected() {
        return idOfPropertyToBeInspected;
    }

    public String getInspectionTimeDate() {
        return inspectionTimeDate;
    }

    public String getInspectionId()
    {
        return inspectionId;
    }


    public IdManager getIdManager() {
        return idManager;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public String getInspectionSuburb() {
        return inspectionSuburb;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Property getInspectionProperty() {
        return inspectionProperty;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s","%s","%s","%s", inspectionId,idOfPropertyToBeInspected,inspectionSuburb,idOfPropertyToBeInspected,inspectionTimeDate,employeeId);
    }



}
