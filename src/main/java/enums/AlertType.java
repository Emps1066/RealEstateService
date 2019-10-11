package enums;

import offerAndApplication.Offer;
import property.Property;

public enum AlertType {
    PROPERTYLISTED {
        @Override
        public String subject() {
            return "Property listed in your area(s)!";
        }

        @Override
        public String message(Property property) {
            String message = "There is a new property in the area of " + property.getSuburb() + "/nIt is at the address"
                    + property.getAddress();
            return message;
        }


    },

    Offer {
        @Override
        public String subject() {
            return "You have a new offer!";
        }

        @Override
        public String message(Property property) {
            String message = "You have a new offer!";
            return message;
        }
    };

    public abstract String subject();

    public abstract String message(Property property);
}
