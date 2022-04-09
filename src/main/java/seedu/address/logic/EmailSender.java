package seedu.address.logic;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class EmailSender {

    private String from;
    private String to;
    private String subject;
    private String content;
    private String password;

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
            MimeMultipart mm_text_image = new MimeMultipart();
            mm_text_image.addBodyPart(text);
            mm_text_image.setSubType("related");

            msg.setContent(mm_text_image);
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
