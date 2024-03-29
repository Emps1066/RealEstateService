package alertSystem;

import enums.AlertType;
import property.Property;
import user.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSystemTLS {
    public void sendEmail(AlertType alertType, String userEmail, Property property) {

        String systemEmail = "projecttrainwreckrmit@gmail.com";
        String password = "s3656005";
        Properties prop = initProperties();

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(systemEmail, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(systemEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(userEmail)
            );

            message.setSubject(alertType.subject());
            if (alertType == AlertType.PROPERTYLISTED) {
                message.setText(alertType.propertyRequiredMessage(property));
            } else {
                message.setText(alertType.message());
            }


            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    public Properties initProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        return prop;
    }


}
