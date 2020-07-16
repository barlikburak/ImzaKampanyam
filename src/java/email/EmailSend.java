package email;

import entity.User;
import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author burak
 */
public class EmailSend implements Serializable {

    public static boolean sendMail(User user) {
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);

            Message mailMessage = new MimeMessage(mailSession);

            mailMessage.setFrom(new InternetAddress("example@gmail.com"));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            mailMessage.setContent(user.getMailOnayUrl(), "text/html");
            mailMessage.setSubject("İmza Kampanyası Onay");

            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", "example@gmail.com", "password");
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            return true;
        } catch (MessagingException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return false;
    }
}
