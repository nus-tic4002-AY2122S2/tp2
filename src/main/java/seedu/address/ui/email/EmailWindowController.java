package seedu.address.ui.email;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import seedu.address.commons.core.LogsCenter;

public class EmailWindowController  {

    private final Logger logger = LogsCenter.getLogger(EmailWindowController.class);

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

        String subject = "";
        String content = "";

        if (event.getSource() == sendButton) {
            subject = subjectTestField.getText();
            content = emailContentArea.getText();
            
        }
    }

    void initData(String from, String to) {
        senderEmailAddress.setText(from);
        receiverEmailAddress.setText(to);
    }
}
