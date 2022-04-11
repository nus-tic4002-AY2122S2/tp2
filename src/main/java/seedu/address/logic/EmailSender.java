package seedu.address.logic;

import seedu.address.ui.email.EmailSendFailAlertWindow;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

        this.from = from;
        this.to = to;
        this.password = password;
        this.subject = subject;
        this.content = content;
    }

    /**
     * Send a email out
     */
    public void sendEmail() {
        try {
            // Create a instance for Email
            Properties props = new Properties();
            gmailTls(props);

            // Set MimeMessage
            Message msg = getMimeMessage(props);
            Transport.send(msg);
        } catch (MessagingException e) {
            //Pop out new window to notify user.
            EmailSendFailAlertWindow emailSendFailAlertWindow = new EmailSendFailAlertWindow();
            emailSendFailAlertWindow.show();
        }
    }

    /**
     * Prepare email MimeMessage
     * @param props email server properties
     * @return MimeMessage
     */
    private Message getMimeMessage(Properties props) {
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.smtp.username"),
                        props.getProperty("mail.smtp.password"));
            }
        });
        session.setDebug(true);
        MimeMessage msg = new MimeMessage(session);

        try {
            // Set sender email address
            msg.setFrom(new InternetAddress(from));
            // Set receiver email address
            msg.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            // Set email subject
            msg.setSubject(subject);
            // Set email content
            msg.setContent(content, "text/html;charset=UTF-8");
        } catch (MessagingException e) {
            //e.printStackTrace();
            //Pop out new window to notify user.
            EmailSendFailAlertWindow emailSendFailAlertWindow = new EmailSendFailAlertWindow();
            emailSendFailAlertWindow.show();
        }

        return msg;
    }

    private void gmailTls(Properties props) {
        //props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.password", this.password);
    }
}
