package property;

import enums.PropertyListType;
import utilities.weekMonthYear.WeekUtil;

public class ForSaleProperty extends Property {
    private String buyerId = null;
    private double price;

    public ForSaleProperty(String ID, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type,
                           String ownerCustomer, double price) {
        super(ID, address, suburb, bedrooms, bathrooms, carSpaces, type, ownerCustomer);
        this.price = price;
    }


    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PropertyListType listType() {
        return PropertyListType.FOR_SALE;
    }

    public String toCsvFormat() {
        return String.format("%s,%f,%s", super.toCsvFormat(), price, buyerId);
    }

    public String toListFormat() {
        StringBuilder list = new StringBuilder();
        list.append(super.toListFormat());
        WeekUtil weekReader = new WeekUtil();
        list.append(String.format("Property For: Sale\n" +
                        "Property For Sale Starting Price: %.2f $\n" +
                        "-----------------------------------------------------------------",
                        price));

        return list.toString();
    }
}