package systemManagers;

import offerAndApplication.Application;
import utilities.dateTime.DateTime;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    private Map<String, Application> pendingApplications = new HashMap<>();
    private Map<String, Application> acceptedApplications = new HashMap<>();
    private String pendingIdSerial = "PA";
    private String acceptedIdSerial = "AA";

    public void makeApplication(String custId, String propertyOwnerId, double preferedRent,
                                String preferedDuration, double custIncome,
                                String custOccupation, String currentEmployer,
                                String pastOccupation, String pastEmployer) {
        DateTime currTime = new DateTime();
        String Id = IdManager.generateUniqueID(pendingIdSerial, "pendingApplication");
        Application application = new Application(Id, custId, propertyOwnerId,
                preferedRent, preferedDuration, custIncome, custOccupation,
                currentEmployer, pastOccupation, pastEmployer, currTime,
                null , null);
        pendingApplications.put(Id, application);
    }


}
