package systemManagers;

import user.User;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

import java.util.List;
import java.util.Map;

public class SuburbManager {
    Scan scan = new Scan();
    FileHandler fileHandler = new FileHandler();
    List<String> myPreferredSuburbs = null;
    List<String> allExistingSuburbs = null;

    private void editSuburbs(User user)
    {
        int choice = scan.askForInt("----------------------\nDo you want to add a suburb or remove a suburb?\n" +
                "1: Add a suburb\n2: Remove a suburb\n------------------");
        if(choice == 1)
        {
            commitEditSuburb(user, "add");
        }

        if(choice == 2)
        {
            commitEditSuburb(user, "delete");
        }

        else{
            System.out.println();
        }
    }

    private void commitEditSuburb(User user, String editType)
    {
        String suburb = scan.askForString("Enter suburb to " + editType + "." ).toLowerCase();
        String fileRoute = "src\\main\\java\\csv\\suburbs\\" + suburb;
        Boolean append = editType.equals("add");
        fileHandler.writeToFile(user.getId(), fileRoute, append);

    }

    public void addSuburbPreference(String suburb) {
        suburb = suburb.toLowerCase();
        if (searchSuburbMapForSuburbExistence(true, suburb) && !searchSuburbMapForSuburbExistence(false, suburb) )
        {
            myPreferredSuburbs.add(suburb);
        } else if (searchSuburbMapForSuburbExistence(false, suburb)) {
            System.out.println("Sorry Suburb Already Exists In Your Preferences");
        } else {
            System.out.println("Sorry Suburb Does Not Exist");
        }
    }

    public void deleteSuburbPreference(String suburb) {
        suburb = suburb.toLowerCase();
        if (searchSuburbMapForSuburbExistence(false, suburb)) {
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



    public Boolean searchSuburbMapForSuburbExistence(Boolean allSuburbs, String suburb)
    {
        boolean exists = false;
        List<String> mapToSearch = null;
        if(allSuburbs == true)
        {
            mapToSearch = allExistingSuburbs;
        }
        else
        {
            mapToSearch = myPreferredSuburbs;
        }

        for (String suburbItter : mapToSearch) {
            if (suburbItter.equals(suburb)) {
                exists = true;
            }
        }
        return exists;

    }

}
