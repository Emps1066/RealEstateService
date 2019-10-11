package property;

import enums.PropertyListType;
import utilities.dateTime.DateTime;
import utilities.weekMonthYear.WeekUtil;

import java.util.List;

public class RentalProperty extends Property {
    private String renterId = null;
    // In Weeks
    private double contractDuration1;
    private double contractDuration2;
    private double contractDuration3;
    private double rentPrice;


    public RentalProperty(String ID, String address, String suburb, int bedrooms,
                          int bathrooms, int carSpaces, String type, String ownerCustomer,
                          double contractDuration1,
                          double contractDuration2, double contractDuration3, double rentPrice) {
        super(ID, address, suburb, bedrooms, bathrooms, carSpaces, type, ownerCustomer);
        this.contractDuration1 = contractDuration1;
        this.contractDuration2 = contractDuration2;
        this.contractDuration3 = contractDuration3;
        this.rentPrice = rentPrice;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public PropertyListType listType() {
        return PropertyListType.RENTAL;
    }



    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String toCsvFormat() {
        return String.format("%s,%f,%f,%f,%f,%s", super.toCsvFormat(),
                contractDuration1, contractDuration2, contractDuration3,
                rentPrice, renterId);
    }

    public String toListFormat() {
        StringBuilder list = new StringBuilder();
        list.append(super.toListFormat());
        WeekUtil weekReader = new WeekUtil();
        list.append(String.format("Property For: Rent\n" +
                                  "Property Weekly Rental Price: %.2f $\n" +
                                  "Available Contract Durations: %s, %s, %s\n" +
                                  "-----------------------------------------------------------------",
                                  rentPrice, weekReader.toString(contractDuration1),
                                  weekReader.toString(contractDuration2),
                                  weekReader.toString(contractDuration3)));

        return list.toString();
    }
}
