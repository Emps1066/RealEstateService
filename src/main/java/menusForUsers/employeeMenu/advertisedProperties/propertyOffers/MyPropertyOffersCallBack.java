package menusForUsers.employeeMenu.advertisedProperties.propertyOffers;

public class MyPropertyOffersCallBack {
    public String menu(String displayable) {
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Employee Main Menu\n");
        menu.append("  -> Advertised Properties Menu\n");
        menu.append("   -> Property Offers\n");

        menu.append("\n");
        menu.append(displayable);
        menu.append("\n");
        menu.append("\n");
        menu.append("Property Offers Menu\n");
        menu.append("1. Back To Advertised Properties Menu\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
