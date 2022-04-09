package seedu.address.ui.email;


import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.EmailSender;

public class EmailWindowController {
    private final Logger logger = LogsCenter.getLogger(EmailWindowController.class);

    private String password;
    private String from;
    private String to;
    private Stage stage;

    @FXML
    private Button cancelButton;

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

            EmailSender emailSender = new EmailSender(from, to, subject, content, password);
            //emailSender.sendEmail();

            EmailSendSuccessfulWindow emailSendSuccessfulWindow = new EmailSendSuccessfulWindow();
            emailSendSuccessfulWindow.show();

            stage.close();
        } else if (event.getSource() == cancelButton) {
            stage.close();
        }
    }

    void initData(String from, String password, String to, Stage stage) {
        senderEmailAddress.setText(from);
        receiverEmailAddress.setText(to);
        this.password = password;
        this.from = from;
        this.to = to;
        this.stage = stage;
    }
}
