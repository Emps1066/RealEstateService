package inspections;

import property.Property;
import systemManagers.IdManager;

public class Inspection {
    IdManager idManager = new IdManager();

    String inspectionId;
    String idOfPropertyToBeInspected;
    String inspectionTimeDate;


    public Inspection(String propertyId, String inspectionTimeDate)
    {
        this.idOfPropertyToBeInspected = propertyId;
        this.inspectionTimeDate = inspectionTimeDate;
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

    public String toCsvFormat() {
        return String.format("%s,%s,%s", getInspectionId(),getIdOfPropertyToBeInspected(),getInspectionTimeDate());
    }



}
