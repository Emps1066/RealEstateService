package offerAndApplication;

import utilities.dateTime.DateTime;
import utilities.weekMonthYear.WeekUtil;

public class Application {

    private String appId;
    private String customerId;
    private String propertyOwnerId;
    private String propertyId;
    private double preferredRent;
    private double preferredDuration;
    private double currentIncome;
    private String currentOccupation;
    private String currentEmployer;
    private String pastOccupation;
    private String pastEmployer;
    private DateTime applicationMadeTime;
    private DateTime applicationAcceptedTime = null;

    public Application(String appId, String customerId, String propertyOwnerId,
                       String propertyId, double preferredRent,
                       double preferredDuration, double currentIncome,
                       String currentOccupation, String currentEmployer,
                       String pastOccupation, String pastEmployer,
                       DateTime applicationMadeTime,
                       DateTime applicationAcceptedTime) {
        this.appId = appId;
        this.customerId = customerId;
        this.propertyOwnerId = propertyOwnerId;
        this.propertyId = propertyId;
        this.preferredRent = preferredRent;
        this.preferredDuration = preferredDuration;
        this.currentIncome = currentIncome;
        this.currentOccupation = currentOccupation;
        this.currentEmployer = currentEmployer;
        this.pastOccupation = pastOccupation;
        this.pastEmployer = pastEmployer;
        this.applicationMadeTime = applicationMadeTime;
        this.applicationAcceptedTime = applicationAcceptedTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public double getPreferredRent() {
        return preferredRent;
    }

    public double getPreferredDuration() {
        return preferredDuration;
    }

    public double getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(double currentIncome) {
        this.currentIncome = currentIncome;
    }

    public String getCurrentOccupation() {
        return currentOccupation;
    }

    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    public String getCurrentEmployer() {
        return currentEmployer;
    }

    public void setCurrentEmployer(String currentEmployer) {
        this.currentEmployer = currentEmployer;
    }

    public String getPastOccupation() {
        return pastOccupation;
    }

    public void setPastOccupation(String pastOccupation) {
        this.pastOccupation = pastOccupation;
    }

    public String getPastEmployer() {
        return pastEmployer;
    }

    public void setPastEmployer(String pastEmployer) {
        this.pastEmployer = pastEmployer;
    }

    public DateTime getApplicationMadeTime() {
        return applicationMadeTime;
    }

    public void setApplicationMadeTime(DateTime applicationMadeTime) {
        this.applicationMadeTime = applicationMadeTime;
    }

    public DateTime getApplicationAcceptedTime() {
        return applicationAcceptedTime;
    }

    public void setApplicationAcceptedTime(DateTime applicationAcceptedTime) {
        this.applicationAcceptedTime = applicationAcceptedTime;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s,%f,%f,%f,%s,%s,%s,%s,%d,%d"
                , appId
                , customerId
                , propertyOwnerId
                , propertyId
                , preferredRent
                , preferredDuration
                , currentIncome
                , currentOccupation
                , currentEmployer
                , pastOccupation
                , pastEmployer
                , (applicationMadeTime == null) ? 0 : applicationMadeTime.getTime()
                , (applicationAcceptedTime == null) ? 0 : applicationAcceptedTime.getTime());
    }

    public String toListFormat() {
        WeekUtil weekUtil = new WeekUtil();
        return String.format("--------------------------------\n" + "Application ID: %s\n" + "Customer ID: %s\n" +
                        "Property ID: %s\n" +
                        "Preferred Rent Amount: %.2f $\n" + "Preferred Duration: %s\n" +
                        "Application Sent on: %s\n" + "Application Accepted on: %s\n" +
                        "Income: %.2f\n" +
                        "Current Occupation: %s\n" + "Current Employer: %s\n" +
                        "Past Occupation: %s\n" + "Past Employer: %s\n" + "--------------------------------",
                appId, customerId, propertyId, preferredRent,
                weekUtil.toString(preferredDuration), applicationMadeTime.toString(),
                applicationAcceptedTime == null ? "N/A" : applicationAcceptedTime.toString(),
                currentIncome,
                currentOccupation, currentEmployer,
                pastOccupation, pastEmployer);
    }
}

