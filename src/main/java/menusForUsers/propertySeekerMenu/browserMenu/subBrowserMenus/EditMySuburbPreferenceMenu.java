package menusForUsers.propertySeekerMenu.browserMenu.subBrowserMenus;


import engine.SystemEngine;
import utilities.scanner.Scan;

public class EditMySuburbPreferenceMenu {
    public void goToEditMySuburbPreferenceMenu(SystemEngine engine, String displayable) {
        EditMySuburbPreferenceMenuCallBack callBack = new EditMySuburbPreferenceMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu(displayable));
        if(option == 1)
        {
            String suburb = Scan.askForString("Enter Name Of Suburb To Add");
            engine.addSuburbPreference(suburb);
            String display = engine.myPreferredSuburbsToListFormat();
            goToEditMySuburbPreferenceMenu(engine, display);
        }
        else if(option == 2)
        {
            String suburb = Scan.askForString("Enter Name Of Suburb To Delete:");
            engine.deleteSuburbPreference(suburb);
            String display = engine.myPreferredSuburbsToListFormat();
            goToEditMySuburbPreferenceMenu(engine, display);
        }
        else {
            String display = engine.getPropertyManager().preferencePropertiesToString(engine.getMyPreferredSuburbs());
            BrowseBySuburbMenu menu = new BrowseBySuburbMenu();
            menu.goToSuburbMenu(engine, display);
        }
    }
}
