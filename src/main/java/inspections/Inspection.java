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
    PropertyManager propertyManager;
    public Inspection(String inspectionId, String propertyId, String inspectionTimeDate, PropertyManager propertyManager)
    {
        this.propertyManager = propertyManager;
        this.inspectionProperty = propertyManager.getPropertyAsObject(propertyId, "approved");
        this.inspectionSuburb = inspectionProperty.getSuburb();
        this.idOfPropertyToBeInspected =  inspectionProperty.getID();
        this.inspectionTimeDate = inspectionTimeDate;
        this.employeeId = inspectionProperty.getEmployee();
        this.inspectionId = inspectionId;
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
