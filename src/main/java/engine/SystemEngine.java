package engine;

import systemManagers.*;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemEngine {
    private User user;
    private List<String> myPreferredSuburbs = new ArrayList<>();
    private List<String> allExistingSuburbs = new ArrayList<>();
    private UserManager userManager;
    private PropertyManager propertyManager;
    private ApplicationManager applicationManager;
    private OfferManager offerManager;
    private RolesManager rolesManager;
    private InspectionManager inspectionManager;

    public SystemEngine(User user, PropertyManager propertyManager, UserManager userManager, ApplicationManager applicationManager, OfferManager offerManager, InspectionManager inspectionManager) {
        this.user = user;
        myPreferredSuburbs = new ArrayList<>();
        this.userManager = userManager;
        this.propertyManager = propertyManager;
        this.applicationManager = applicationManager;
        this.offerManager = offerManager;
        this.inspectionManager = inspectionManager;
        rolesManager = new RolesManager();
    }

    // Methods For Preference Suburb

    public void addSuburbPreference(String suburb) {
        suburb = suburb.toLowerCase();
        if (suburbExists(suburb) && !suburbExistsInMypreferences(suburb)) {
            myPreferredSuburbs.add(suburb);
        } else if (suburbExistsInMypreferences(suburb)) {
            System.out.println("Sorry Suburb Already Exists In Your Preferences");
        } else {
            System.out.println("Sorry Suburb Does Not Exist");
        }
    }

    public void deleteSuburbPreference(String suburb) {
        suburb = suburb.toLowerCase();
        if (suburbExistsInMypreferences(suburb)) {
            myPreferredSuburbs.remove(suburb);
        } else {
            System.out.println("Sorry Suburb Does Not Exist In Your Preferences");
        }
    }

    public String myPreferredSuburbsToListFormat() {
        StringBuilder list = new StringBuilder();
        list.append("-----------------------\n");
        list.append("My Preferences\n");
        for (String suburb : myPreferredSuburbs) {
            list.append(String.format("%s\n", suburb));
        }
        list.append("-----------------------");
        return list.toString();
    }

    private boolean suburbExistsInMypreferences(String suburb) {
        boolean exists = false;
        for (String suburbItter : myPreferredSuburbs) {
            if (suburbItter.equals(suburb)) {
                exists = true;
            }
        }
        return exists;
    }

    private boolean suburbExists(String suburb) {
        boolean exists = false;
        for (String suburbItter : allExistingSuburbs) {
            if (suburbItter.equals(suburb)) {
                exists = true;
            }
        }
        return exists;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public List<String> getMyPreferredSuburbs() {
        return myPreferredSuburbs;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    public ApplicationManager getApplicationManager() {
        return applicationManager;
    }

    public OfferManager getOfferManager() {
        return offerManager;
    }

    public RolesManager getRolesManager() {
        return rolesManager;
    }


    public InspectionManager getInspectionManager() {
        return inspectionManager;
    }

    public void saveToSystem() {
        userManager.saveToSystem();
        propertyManager.saveToSystem();
        applicationManager.saveToSystem();
        offerManager.saveToSystem();
    }
}
