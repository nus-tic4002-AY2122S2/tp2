package seedu.address.ui.email;

import java.util.logging.Logger;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import seedu.address.commons.core.LogsCenter;

import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;


public class EmailWindowController  {

    private final static Logger logger = LogsCenter.getLogger(EmailWindowController.class);

    private String password;
    private String from;
    private String to;

    @FXML
    private Button sendButton;

    @FXML
    private Label senderEmailAddress;

    @FXML
    private Label receiverEmailAddress;

    @FXML
    private TextField subjectTestField;

    @FXML
    private TextArea emailContentArea;

    @FXML
    void handleButtonAction(ActionEvent event) {

        if (event.getSource() == sendButton) {
            String subject = subjectTestField.getText();
            String content = emailContentArea.getText();
            sendEmail(subject, content);
        }
    }

    void initData(String from, String password, String to) {
        senderEmailAddress.setText(from);
        receiverEmailAddress.setText(to);
        this.password = password;
        this.from = from;
        this.to = to;
    }

    private void sendEmail(String subject, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        Message message = prepareMessage(session, from, to, subject, content);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            logger.info(" -------- Email Send Process Failed -------- ");
            e.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String sender,
                                          String receiver, String subject,
                                          String content) {

        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            // Create Email
            mimeMessage.setFrom(new InternetAddress(sender));
            mimeMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(content);

            return mimeMessage;

        } catch (MessagingException e) {

            logger.info(" -------- Email Prepare Process Failed -------- ");
            e.printStackTrace();
        }

        return mimeMessage;
    }
}
