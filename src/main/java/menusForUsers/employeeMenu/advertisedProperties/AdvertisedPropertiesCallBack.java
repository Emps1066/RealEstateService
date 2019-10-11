package menusForUsers.propertySeekaMenu.employeeMenu.advertisedProperties;

public class AdvertisedPropertiesCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Employee Main Menu\n");
        menu.append("  -> Advertised Properties Menu\n");
        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property View My Offer Menu\n");
        menu.append("1. See Inspections\n");
        menu.append("2. Review Applications\n");
        menu.append("3. Back To Employee Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
