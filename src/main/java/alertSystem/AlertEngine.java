package alertSystem;

import enums.AlertType;
import property.Property;
import user.Customer;
import user.User;
import utilities.fileHandler.FileHandler;

import java.io.File;


public class AlertEngine {



    public void newPropertyListed(Property property, AlertType alertType)
    {
        MailSystemTLS email = new MailSystemTLS();
        FileHandler fileHandler = new FileHandler();

        //email.sendEmail(alertType, property);
    }

    public void generateAlert()
    {

    }

}




