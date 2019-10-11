package menusForUsers.propertyOwnerMenu.myPropertiesMenu;

import enums.PropertyListType;
import menusForUsers.propertyOwnerMenu.myPropertiesMenu.editPropertyDetailsMenu.EditPropertyDetailsMenu;
import menusForUsers.propertyOwnerMenu.PropertyOwnerMenu;
import property.Property;
import systemManagers.PropertyManager;
import utilities.scanner.Scan;
import engine.SystemEngine;


public class MyPropertiesMenu {

    public void goToMyPropertiesMenu(SystemEngine engine, String displayable) {
        MyPropertiesMenuCallBack callBack = new MyPropertiesMenuCallBack();
        int option = Scan.askForOption(4, callBack.menu(displayable));

        PropertyManager propertyManager = engine.getPropertyManager();
        if (option == 1) {

            Property property = propertyManager.askForPropertyDetails(engine.getUser().getId(), PropertyListType.RENTAL);
            propertyManager.addProperty(property);
        } else if (option == 2) {

            Property property = propertyManager.askForPropertyDetails(engine.getUser().getId(), PropertyListType.FOR_SALE);
            propertyManager.addProperty(property);
        } else if (option == 3) {

            String propertyId = Scan.askForString("Enter The Property ID Of The Property To Edit:");
            String propertyString = propertyManager.getMyPropertyToEdit(propertyId, engine.getUser().getId());
            if(propertyString.equals("")) {
                System.out.println("Property Does Not Exist Or You are Not Allowed To Edit");

                goToMyPropertiesMenu(engine, displayable);
            } else {
                EditPropertyDetailsMenu menu = new EditPropertyDetailsMenu();
                menu.goToEditPropertyDetailsMenu(engine, propertyString, propertyId);
            }
        } else {
            PropertyOwnerMenu menu = new PropertyOwnerMenu();
            menu.goToPropertyOwnerMenu(engine);
        }

        String display = propertyManager.myPropertiesToString(engine.getUser().getId());

        goToMyPropertiesMenu(engine, display);
    }
}
