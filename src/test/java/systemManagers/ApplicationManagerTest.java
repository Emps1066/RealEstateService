package systemManagers;

import offerAndApplication.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import property.Property;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationManagerTest {

    @Test
    void addAndAcceptApplication() {
        ApplicationManager applicationManager = new ApplicationManager(new HashMap<>());
        Application application = new Application(null, "C0", "C1",
                "P", 300, 4, 1000, "Builder", "CHINGU Corp",
         "Add Corp", "painter", null, null);

        applicationManager.addNewApplication(application);
        int currentIdCount = IdManager.getIdCount("pendingApplication") - 1;
        String Id = "PA" + currentIdCount;
        applicationManager.acceptApplication(Id, "C1", new PropertyManager(new HashMap<>(),new HashMap<>(), new HashMap<>()));
    }

    @Test
    void acceptApplication() {
        ApplicationManager applicationManager = new ApplicationManager(new HashMap<>());
        Application application = new Application(null, "C0", "C1",
                "P", 300, 4, 1000, "Builder", "CHINGU Corp",
                "Add Corp", "painter", null, null);

        applicationManager.addNewApplication(application);
        int currentIdCount = IdManager.getIdCount("pendingApplication") - 1;
        String Id = "PA" + currentIdCount;
        applicationManager.acceptApplication(Id, "C1", new PropertyManager(new HashMap<>(),new HashMap<>(), new HashMap<>()));
    }
    @Test
    void acceptApplicationNotYours() {
        ApplicationManager applicationManager = new ApplicationManager(new HashMap<>());
        Application application = new Application(null, "C0", "C1",
                "P", 300, 4, 1000, "Builder", "CHINGU Corp",
                "Add Corp", "painter", null, null);

        applicationManager.addNewApplication(application);
        int currentIdCount = IdManager.getIdCount("pendingApplication") - 1;
        String Id = "PA" + currentIdCount;
        applicationManager.acceptApplication(Id, "C2", new PropertyManager(new HashMap<>(),new HashMap<>(), new HashMap<>()));
    }

    @Test
    void acceptWrongApplication() {
        ApplicationManager applicationManager = new ApplicationManager(new HashMap<>());
        Application application = new Application(null, "C0", "C1",
                "P", 300, 4, 1000, "Builder", "CHINGU Corp",
                "Add Corp", "painter", null, null);

        applicationManager.addNewApplication(application);
        int currentIdCount = IdManager.getIdCount("pendingApplication") - 1;
        String Id = "PA" + currentIdCount + 1;
        applicationManager.acceptApplication(Id, "C1", new PropertyManager(new HashMap<>(),new HashMap<>(), new HashMap<>()));
    }
}