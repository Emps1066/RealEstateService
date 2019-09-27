package offerAndApplication;

import utilities.dateTime.DateTime;

public class Application {

    private String appId;
    private String custId;
    private String propertyOwnerId;
    private double preferedRent;
    private String preferedDuration;
    private double custIncome;
    private String custOccupation;
    private String currentEmployer;
    private String pastOccupation;
    private String pastEmployer;
    private DateTime applicationMadeTime;
    private DateTime applicationAcceptedTime = null;
    private DateTime applicationSetInStoneTime = null;

    public Application(String appId, String custId, String propertyOwnerId,
                       double preferedRent,
                       String preferedDuration, double custIncome,
                       String custOccupation, String currentEmployer,
                       String pastOccupation, String pastEmployer,
                       DateTime applicationMadeTime,
                       DateTime applicationAcceptedTime,
                       DateTime applicationSetInStoneTime) {
        this.appId = appId;
        this.custId = custId;
        this.propertyOwnerId = propertyOwnerId;
        this.preferedRent = preferedRent;
        this.preferedDuration = preferedDuration;
        this.custIncome = custIncome;
        this.custOccupation = custOccupation;
        this.currentEmployer = currentEmployer;
        this.pastOccupation = pastOccupation;
        this.pastEmployer = pastEmployer;
        this.applicationMadeTime = applicationMadeTime;
        this.applicationAcceptedTime = applicationAcceptedTime;
        this.applicationSetInStoneTime = applicationSetInStoneTime;
    }

    public String getAppId() {
        return appId;
    }

    public String getCustId() {
        return custId;
    }

    public String getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public double getPreferedRent() {
        return preferedRent;
    }

    public String getPreferedDuration() {
        return preferedDuration;
    }

    public double getCustIncome() {
        return custIncome;
    }

    public void setCustIncome(double custIncome) {
        this.custIncome = custIncome;
    }

    public String getCustOccupation() {
        return custOccupation;
    }

    public void setCustOccupation(String custOccupation) {
        this.custOccupation = custOccupation;
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

    public DateTime getApplicationSetInStoneTime() {
        return applicationSetInStoneTime;
    }

    public void setApplicationSetInStoneTime(DateTime applicationSetInStoneTime) {
        this.applicationSetInStoneTime = applicationSetInStoneTime;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%f,%s,%f,%s,%s,%s,%s,%d,%d,%d"
                ,appId
                ,custId
                ,propertyOwnerId
                ,preferedRent
                ,preferedDuration
                ,custIncome
                ,custOccupation
                ,currentEmployer
                ,pastOccupation
                ,pastEmployer
                ,applicationMadeTime.getTime()
                ,applicationAcceptedTime == null ? 0 : applicationAcceptedTime.getTime()
                ,applicationSetInStoneTime == null ? 0 : applicationSetInStoneTime.getTime());
    }

    public String toListFormat() {
        return String.format("--------------------------------\n" + "Application ID: %s\n" + "Customer ID: %s\n" +
                        "Preferred Rent Amount: %.2f\n" + "Preferred Duration: %s\n" +
                        "Application Sent on: %s\n" + "Application Accepted on: %s\n" +
                        "Income: %.2f\n" +
                        "Current Occupation: %s\n" + "Current Employer: %s\n" +
                        "Past Occupation: %s\n" + "Past Employer: %s\n" + "--------------------------------",
                appId, custId, preferedRent,
                preferedDuration, applicationMadeTime.toString(),
                applicationAcceptedTime == null ? "N/A" : applicationAcceptedTime.toString(),
                custIncome,
                custOccupation, currentEmployer,
                pastOccupation, pastEmployer);
    }
}

