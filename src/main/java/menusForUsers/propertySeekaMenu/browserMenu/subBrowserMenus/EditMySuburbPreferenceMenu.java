package menusForUsers.propertySeekaMenu.browserMenu.subBrowserMenus;


import scanner.Scan;

public class EditMySuburbPreferenceMenu {
    public void goToEditMySuburbPreferenceMenu() {
        EditMySuburbPreferenceMenuCallBack callBack = new EditMySuburbPreferenceMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu());
        if(option == 1)
        {
            goToEditMySuburbPreferenceMenu();
        }
        else if(option == 2)
        {
            goToEditMySuburbPreferenceMenu();
        }
        else {
            BrowseBySuburbMenu menu = new BrowseBySuburbMenu();
            menu.goToSuburbMenu();
        }
    }
}
