package systemManagers;

import enums.PropertyListType;
import offerAndApplication.Application;
import user.User;
import utilities.dateTime.DateTime;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private static final int DAYS_TO_ACCEPT_ACCEPTED_APPLICATION = 1;
    private static final int DAYS_TO_ACCEPT_PENDING_APPLICATION = 3;

    private Map<String, Application> applications = new HashMap<>();
    private String pendingIdSerial = "PA";
    private String acceptedIdSerial = "AA";

    public ApplicationManager(Map<String, Application> applications) {
        this.applications = applications;
    }

    // To Create And Send Application

    public void sendApplication(User user, PropertyManager propertyManager) {
        String propertyId = Scan.askForString("Enter The ID of the Property To Send Application To:");
        if (propertyManager.propertyExistsAsListed(propertyId, PropertyListType.RENTAL)) {
            Application application = askForApplicationDetails(user.getId(),
                    propertyManager.getPropertyOwnerId(propertyId), propertyId);
            addNewApplication(application);
        } else {
            System.out.println("Sorry The Property Entered Could Not Be Found, please try again later");
        }
    }

    public Application askForApplicationDetails(String renterCustomerId, String propertyOwnerId, String propertyId) {
        double preferredRent = Scan.askForDouble("Enter Preferred Weekly Rent Price:");
        double preferredDuration = Scan.askForDouble("Enter Preferred Rental Duration(in weeks):");
        double customerIncome = Scan.askForDouble("Enter Your Yearly income:");
        String customerOccupation = Scan.askForString("Enter Your Current Occupation:");
        String currentEmployer = Scan.askForString("Enter Your Current Employers Name:");
        String pastOccupation = Scan.askForString("Enter Your Previous Occupation:");
        String pastEmployer = Scan.askForString("Enter Your Previous Employer:");
        Application application = new Application(null, renterCustomerId, propertyOwnerId, propertyId,
                preferredRent, preferredDuration, customerIncome, customerOccupation,
                currentEmployer, pastOccupation, pastEmployer, null,
                null);

        return application;
    }

    public void addNewApplication(Application application) {
        DateTime currTime = new DateTime();
        String Id = IdManager.generateUniqueID(pendingIdSerial, "pendingApplication");
        application.setApplicationMadeTime(currTime);
        application.setAppId(Id);
        applications.put(Id, application);
        IdManager.updateUniqueIdValue("pendingApplication");
        System.out.println("\nApplication Sent\n");
    }

    // To Accept Applications

    // this method has to be used together with unlisting the property
    public boolean acceptApplication(String appId, String propertyOwnerId, PropertyManager propertyManager) {

        boolean accepted = false;
        Application application = applications.get(appId);
        if (application != null) {
            if (application.getAppId().startsWith(pendingIdSerial)) {
                if (!applicationIsExpired(application, DAYS_TO_ACCEPT_PENDING_APPLICATION) &&
                        application.getAppReceiverId().equals(propertyOwnerId)) {

                    DateTime currTime = new DateTime();
                    String Id = IdManager.generateUniqueID(acceptedIdSerial, "acceptedApplication");
                    application.setApplicationAcceptedTime(currTime);
                    application.setAppId(Id);
                    IdManager.updateUniqueIdValue("acceptedApplication");

                    propertyManager.unlistProperty(application.getPropertyId());
                    System.out.println("\nApplication Accepted\n");
                    accepted = true;
                } else {
                    System.out.println("Application Is Not Yours To Accept Or Is Expired");
                }
            } else {
                System.out.println("Application Not Acceptable");
            }
        } else {
            System.out.println("Application Does Not Exist");
        }

        return accepted;
    }

    // To Finalise Applications

    //Returns String to put underContract
    public boolean finaliseApplication(String appId, String renterCustomerId, InspectionManager inspectionManager, PropertyManager propertyManager) {
        boolean finalised = false;
        Application application = applications.get(appId);
        if (application != null) {
            if (application.getAppId().startsWith(acceptedIdSerial)) {
                if (!applicationIsExpired(application, DAYS_TO_ACCEPT_ACCEPTED_APPLICATION) &&
                        application.getAppSenderId().equals(renterCustomerId)) {

                    propertyManager.setPropertyUnderContract(application.getPropertyId(), renterCustomerId, inspectionManager, propertyManager);

                    withdrawApplication(appId, renterCustomerId);
                    System.out.println("\nPayments Have Been Finalised Rental Property Ready To Move In\n");
                    finalised = true;
                } else {
                    System.out.println("Application Is Not Yours To Finalise Or Is Expired");
                }
            } else {
                System.out.println("Application Can Not Finalise");
            }
        } else {
            System.out.println("Application Does Not Exist");
        }

        return finalised;
    }

    // WithDraw/Reject Applications

    public void withdrawApplication(String appId, String renterCustomerId) {
        Application application = applications.get(appId);
        if (application != null) {
            if (application.getAppSenderId().equals(renterCustomerId)) {
                applications.remove(appId);
                System.out.println("\nApplication Has Been Withdrawn\n");
            } else {
                System.out.println("Application Is Not Yours To Withdraw");
            }
        } else {
            System.out.println("Application Does Not Exist Or Is Expired");
        }
    }

    public void rejectApplication(String appId, String appReceiverId) {
        Application application = applications.get(appId);
        if (application != null) {
            if (application.getAppReceiverId().equals(appReceiverId)) {
                applications.remove(appId);
                System.out.println("\nApplication Has Been Rejected\n");
            } else {
                System.out.println("Application Is Not Yours To Reject");
            }
        } else {
            System.out.println("Application Does Not Exist Or Is Expired");
        }
    }

    // To Display Applications

    public String getApplicationString(String appId) {
        return applications.get(appId).toListFormat();
    }

    private String propertySeekerAppsToListFormat(String seekerId, int daysTillExpiration, String appIdSerial) {

        StringBuilder list = new StringBuilder();
        for (Application application : applications.values()) {
            if (application.getAppId().startsWith(appIdSerial)) {

                if (application.getAppSenderId().equals(seekerId) &&
                        !applicationIsExpired(application, daysTillExpiration)) {
                    list.append(application.toListFormat());
                    list.append("\n");
                }
            }
        }
        return list.toString();
    }

    public String propertySeekerAcceptedAppsToListFormat(String seekerId) {
        return propertySeekerAppsToListFormat(seekerId, DAYS_TO_ACCEPT_ACCEPTED_APPLICATION, acceptedIdSerial);
    }

    public String propertySeekerPendingAppsToListFormat(String seekerId) {
        return propertySeekerAppsToListFormat(seekerId, DAYS_TO_ACCEPT_PENDING_APPLICATION, pendingIdSerial);
    }

    public String propertySeekerAllAppsToListFormat(String seekerId) {
        StringBuilder list = new StringBuilder();
        list.append(propertySeekerAcceptedAppsToListFormat(seekerId));
        list.append(propertySeekerPendingAppsToListFormat(seekerId));
        return list.toString();
    }

    public String propertyOwnerAppsToListFormat(String propertyOwnerId) {
        StringBuilder list = new StringBuilder();
        for (Application application : applications.values()) {
            if (application.getAppId().startsWith(pendingIdSerial)) {

                if (application.getAppReceiverId().equals(propertyOwnerId) &&
                        !applicationIsExpired(application, DAYS_TO_ACCEPT_PENDING_APPLICATION)) {
                    list.append(application.toListFormat());
                    list.append("\n");
                }
            }
        }
        return list.toString();
    }

    // Boolean Methods

    private boolean applicationIsExpired(Application application, int daysTillExpiration) {
        boolean expired = false;
        DateTime dateStarted;
        if (application.getApplicationAcceptedTime() != null) {
            dateStarted = application.getApplicationAcceptedTime();
        } else {
            dateStarted = application.getApplicationMadeTime();
        }
        DateTime currentDate = new DateTime();
        int daysPassed = DateTime.diffDays(currentDate, dateStarted);
        if (daysPassed >= daysTillExpiration) {
            expired = true;
        }

        return expired;
    }

    public boolean userCanEdit(String appId, String renterId) {
        boolean can = false;
        Application application = applications.get(appId);
        if (application != null) {
            if (application.getAppSenderId().equals(renterId)) {
                can = true;
            }
        }
        return can;
    }

    // Application Editors

    public void updateCurrentIncome(String appId, double currentIncome) {
        applications.get(appId).setCurrentIncome(currentIncome);
    }

    public void updateCurrentOccupation(String appId, String currOccupation) {
        applications.get(appId).setCurrentOccupation(currOccupation);
    }

    public void updateCurrentEmployer(String appId, String currEmployer) {
        applications.get(appId).setCurrentEmployer(currEmployer);
    }

    public void updatePastOccupation(String appId, String pastOccupation) {
        applications.get(appId).setPastOccupation(pastOccupation);
    }

    public void updatePastEmployer(String appId, String pastEmployer) {
        applications.get(appId).setPastEmployer(pastEmployer);
    }

    private void saveApplicationToFile(Application application) {
        FileHandler.writeToFile(application.toCsvFormat(), "src\\main\\java\\csv\\application\\application.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\application\\application.csv", true);
    }

    public void saveToSystem() {
        FileHandler.writeToFile("", "src\\main\\java\\csv\\application\\application.csv", false);
        for (Application application : applications.values()) {
            saveApplicationToFile(application);
        }
    }

//
//    private boolean acceptedApplicationExists(String appId) {
//        boolean exists = false;
//        for(Application application : acceptedApplications.values()) {
//            if(application.getAppId().equals(appId)) {
//                exists = true;
//            }
//        }
//        return exists;
//    }
//    public boolean acceptApplication(String applicationId, ) {
//
//    }
//
//    public boolean payDeposit(String applicationId, ) {
//
//    }
}
