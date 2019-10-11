package menusForUsers.propertyOwnerMenu.myPropertiesMenu.editPropertyDetailsMenu;

public class EditPropertyDetailsMenuCallBack {

        public String menu(String displayable) {
            StringBuilder menu = new StringBuilder();

            menu.append("*******************************************\n");
            menu.append(" -> Property Owner Menu\n");
            menu.append("  -> My Applicants Menu\n");
            menu.append("   -> Edit Property Details Menu\n");
            menu.append("\n");
            menu.append(displayable);
            menu.append("\n");
            menu.append("\n");
            menu.append(" Edit Property Details Menu\n");
            menu.append("1. Edit Address\n");
            menu.append("2. Edit Suburb\n");
            menu.append("3. Edit Number Of Bedrooms\n");
            menu.append("4. Edit Number Of bathrooms\n");
            menu.append("5. Edit Number of Car Spaces");
            menu.append("6. Edit Property Type");
            menu.append("7. Edit Pricing");
            menu.append("8. Back to My Properties Menu");
            menu.append("*******************************************");

            return menu.toString();
        }
    }


