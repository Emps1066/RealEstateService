package alertSystem;

import enums.AlertType;
import inspections.Inspection;
import property.Property;
import utilities.fileHandler.FileHandler;

import java.io.*;
import java.util.List;


public class AlertEngine {


    FileHandler fileHandler = new FileHandler();
    MailSystemTLS email = new MailSystemTLS();


    public void sendEmailsToCustomers(List<String> idsToEmail, Property property, AlertType alertType)
    {
        String userEmail = null;
        for (String temp : idsToEmail) {
            for (int i = 0; i < 3; i++) {
                userEmail = fileHandler.get(temp, 2, "src\\main\\java\\csv\\users\\customer");
            }
            email.sendEmail(alertType, userEmail, property);
        }
    }

    public void newPropertyListed(Property property, AlertType alertType) {
        List<String> idsToEmail = getIdsToEmail(property);
        sendEmailsToCustomers(idsToEmail, property, alertType);
    }

    public List<String> getIdsToEmail(Property property)
    {
        List<String> idsToEmail = null;
        try {
            idsToEmail = readData(property);
        } catch (IOException e) {
            System.out.println("Could not find file");
        }
        return  idsToEmail;
    }

    public void inspectionAlert(Inspection inspection, AlertType alertType) {
        Property property = inspection.getInspectionProperty();
        List<String> idsToEmail = getIdsToEmail(property);
        sendEmailsToCustomers(idsToEmail, property, alertType);
    }



    public void inspectionCancelled(Inspection inspection)
    {
        Property property = inspection.getInspectionProperty();
        AlertType alertType = AlertType.INSPECTION_CANCELLED;
        List<String> idsToEmail = getIdsToEmail(property);
        idsToEmail.add(inspection.getEmployeeId());
        sendEmailsToCustomers(idsToEmail, property, alertType);

    }

    public List<String> readData(Property property) throws IOException {
        String file = "src\\main\\java\\csv\\suburbs\\" + property.getSuburb();
        List<String> content = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null) {
                content.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
        return content;
    }

}




