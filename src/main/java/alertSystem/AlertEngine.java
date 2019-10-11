package alertSystem;

import enums.AlertType;
import org.graalvm.compiler.lir.LIRInstruction;
import property.Property;
import user.Customer;
import user.User;
import utilities.fileHandler.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AlertEngine {


    FileHandler fileHandler = new FileHandler();

    public void newPropertyListed(Property property, AlertType alertType) {
        String userEmail = null;
        Customer customer = null;
        List<String> idsToEmail = null;

        MailSystemTLS email = new MailSystemTLS();
        try {
            idsToEmail = readData(property);
        } catch (IOException e) {
            System.out.println("Could not find file");
        }
        for (String temp : idsToEmail) {
            for (int i = 0; i < 3; i++) {
                userEmail = fileHandler.get(temp, 2, "src\\main\\java\\csv\\users\\customer");
            }
            email.sendEmail(alertType, userEmail, property);
        }


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




