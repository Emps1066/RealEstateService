package offerAndApplication;

import utilities.dateTime.DateTime;
import utilities.weekMonthYear.WeekUtil;

import java.util.Objects;

public class Application {

    private String appId;
    private String appSenderId;
    private String appReceiverId;
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

    public Application(String appId, String appSenderId, String appReceiverId,
                       String propertyId, double preferredRent,
                       double preferredDuration, double currentIncome,
                       String currentOccupation, String currentEmployer,
                       String pastOccupation, String pastEmployer,
                       DateTime applicationMadeTime,
                       DateTime applicationAcceptedTime) {
        this.appId = appId;
        this.appSenderId = appSenderId;
        this.appReceiverId = appReceiverId;
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

    public String getAppSenderId() {
        return appSenderId;
    }

    public String getAppReceiverId() {
        return appReceiverId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Double.compare(that.preferredRent, preferredRent) == 0 &&
                Double.compare(that.preferredDuration, preferredDuration) == 0 &&
                Double.compare(that.currentIncome, currentIncome) == 0 &&
                appId.equals(that.appId) &&
                appSenderId.equals(that.appSenderId) &&
                appReceiverId.equals(that.appReceiverId) &&
                propertyId.equals(that.propertyId) &&
                currentOccupation.equals(that.currentOccupation) &&
                currentEmployer.equals(that.currentEmployer) &&
                pastOccupation.equals(that.pastOccupation) &&
                pastEmployer.equals(that.pastEmployer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, appSenderId, appReceiverId, propertyId, preferredRent, preferredDuration, currentIncome, currentOccupation, currentEmployer, pastOccupation, pastEmployer);
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s,%f,%f,%f,%s,%s,%s,%s,%d,%d"
                , appId
                , appSenderId
                , appReceiverId
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
                appId, appSenderId, propertyId, preferredRent,
                weekUtil.toString(preferredDuration), applicationMadeTime.toString(),
                applicationAcceptedTime == null ? "N/A" : applicationAcceptedTime.toString(),
                currentIncome,
                currentOccupation, currentEmployer,
                pastOccupation, pastEmployer);
    }
}

