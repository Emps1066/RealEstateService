package enums;

import offerAndApplication.Offer;
import property.Property;

public enum AlertType {
    PROPERTYLISTED {

        public String subject() {
            return "Property listed in your area(s)!";
        }

        public String propertyRequiredMessage(Property property) {
            String message = "There is a new property in the area of " + property.getSuburb() + "/nIt is at the address"
                    + property.getAddress();
            return message;
        }


    },

    OFFER {
        public String subject() {
            return "You have a new offer!";
        }

        public String message() {
            String message = "You have a new offer!";
            return message;
        }
    },
    INSPECTION_CREATED {
        public String subject() {
            String subject = "New inspection!";
            return subject;
        }

        public String message() {
            String message = "Please be aware that there is a new inspection listed.";
            return message;
        }
    },

    INSPECTION_CANCELLED {
        public String subject() {
            String subject = "Inspection has being cancelled!";
            return subject;
        }


        public String message() {
            String message = "Sadly the inspection has being cancelled";
            return message;
        }
    };

    public String message()
    {
       String message = null;
       return message;
    }

    public String subject()
    {
        String sunject = null;
        return subject();
    }

    public String propertyRequiredMessage(Property property)
    {
        return null;
    }
}
