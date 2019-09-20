package alertSystem;

import user.Customer;
import user.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSystemTLS {

        public void sendEmail()
        {

            String systemEmail = "projecttrainwreckrmit@gmail.com";
            String password = "s3656005";

            Properties prop = new Properties();
            prop = initProperties();


            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(systemEmail , password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(systemEmail));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse("harryluke@hotmail.com")
                );
                message.setSubject("Testing Gmail TLS");
                message.setText("Dear Mail Crawler,"
                        + "\n\n Please do not spam my email!");

                Transport.send(message);


            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }




        public Properties initProperties()
        {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
            return prop;
        }




    }
