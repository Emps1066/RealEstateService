package menusForUsers.propertyOwnerMenu.myPropertiesMenu.editPropertyDetailsMenu;

import menusForUsers.propertyOwnerMenu.myPropertiesMenu.MyPropertiesMenu;
import property.Property;
import systemManagers.PropertyManager;
import utilities.scanner.Scan;
import engine.SystemEngine;

public class EditPropertyDetailsMenu {

    public void goToEditPropertyDetailsMenu(SystemEngine engine, String displayable, String propertyId) {
        EditPropertyDetailsMenuCallBack callBack = new EditPropertyDetailsMenuCallBack();
        int option = Scan.askForOption(7, callBack.menu(displayable));

        PropertyManager propertyManager = engine.getPropertyManager();
        if (option == 1) {
            String address = Scan.askForString("Enter New Address:");

            propertyManager.editAddress(propertyId, address);
        }
        else if (option == 2) {
            String suburb = Scan.askForString("Enter New Suburb:");

            propertyManager.editSuburb(propertyId, suburb);
        }
        else if (option == 3) {
            int bedrooms = Scan.askForInt("Enter Number Of Bedrooms:");

            propertyManager.editNumberOfBedrooms(propertyId, bedrooms);
        }
        else if (option == 4) {
            int bathrooms = Scan.askForInt("Enter Number Of Bathrooms:");

            propertyManager.editNumberOfBathrooms(propertyId, bathrooms);
        }
        else if (option == 5) {
            int carSpaces = Scan.askForInt("Enter Number Of Car Spaces:");

            propertyManager.editNumberOfCarSpaces(propertyId, carSpaces);
        }
        else if (option == 6) {
            String type = Scan.askForString("Enter New Property Type:");

            propertyManager.editPropertyType(propertyId, type);
        }
        else if (option == 7) {
            double price = Scan.askForDouble("Enter New Pricing:");

            propertyManager.editPricing(propertyId, price);
        }
        else {
            String display = propertyManager.myPropertiesToString(engine.getUser().getId());

            MyPropertiesMenu menu = new MyPropertiesMenu();
            menu.goToMyPropertiesMenu(engine, display);
        }

        String propertyString = propertyManager.getMyPropertyToEdit(propertyId, engine.getUser().getId());

        goToEditPropertyDetailsMenu(engine, propertyString, propertyId);
    }
}
