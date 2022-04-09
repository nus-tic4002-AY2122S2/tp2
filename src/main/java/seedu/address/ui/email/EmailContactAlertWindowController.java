package seedu.address.ui.email;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmailContactAlertWindowController {

    private Stage stage;

    @FXML
    private Label alertMessage;

    @FXML
    private Button okButton;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == okButton) {
            stage.close();
        }
    }

    void initData(Stage stage) {
        this.stage = stage;
        String alertMessage = "Please key in valid INTEGER number within range.";
        this.alertMessage.setText(alertMessage);
    }
}
