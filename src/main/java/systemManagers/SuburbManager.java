package systemManagers;

import user.User;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

public class SuburbManager {
    Scan scan = new Scan();
    FileHandler fileHandler = new FileHandler();


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





}
