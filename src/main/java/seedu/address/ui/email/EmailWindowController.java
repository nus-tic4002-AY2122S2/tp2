package seedu.address.ui.email;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmailWindowController {

    @FXML
    private Button sendButton;

    @FXML
    private Label senderEmailAddress;

    @FXML
    private Label receiverEmailAddress;

    @FXML
    private TextField subjuctTestFeild;

    @FXML
    private TextArea emailContentArea;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == sendButton) {
            String subject = subjuctTestFeild.getText().trim();
            String content = emailContentArea.getText().trim();
        }
    }

    @FXML
    void initialize(String from, String to) {
        senderEmailAddress.setText(from);
        receiverEmailAddress.setText(to);
    }
}
