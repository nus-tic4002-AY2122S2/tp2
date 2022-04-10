package seedu.address.logic;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

    private String from;
    private String to;
    private String subject;
    private String content;
    private String password;

    /**
     * Create a new Email Sender
     * @param from is sender email address
     * @param to is receiver email address
     * @param subject is the email subject
     * @param content is the email content
     * @param password is the password of sender email
     */
    public EmailSender(String from,
                       String to,
                       String subject,
                       String content,
                       String password) {

        this.from = "tic4003tp5@gmail.com";
        this.to = "michealyang1994@gmail.com";
        this.password = "nusyear4";
        this.subject = "Greeting";
        this.content = "Hi Micheal";
    }

    /**
     * Send a email out
     */
    public void sendEmail() {
        // Create a instance for Email
        Properties props = new Properties();
        gmailTls(props);

        // Set MimeMessage
        MimeMessage msg = getMimeMessage(props);

        try {
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prepare email MimeMessage
     * @param props email server properties
     * @return MimeMessage
     */
    private MimeMessage getMimeMessage(Properties props) {
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        MimeMessage msg = new MimeMessage(session);

        try {
            // Set sender email address
            msg.setFrom(new InternetAddress(from));

            // Set receiver email address
            msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));

            // Set email subject
            msg.setSubject(subject, "UTF-8");

            MimeBodyPart text = new MimeBodyPart();
            text.setContent(content, "text/html;charset=UTF-8");
            MimeMultipart mmTextImage = new MimeMultipart();
            mmTextImage.addBodyPart(text);
            mmTextImage.setSubType("related");

            msg.setContent(mmTextImage);
            msg.setSentDate(new Date());

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return msg;
    }

    private static void gmailTls(Properties props) {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }
}
