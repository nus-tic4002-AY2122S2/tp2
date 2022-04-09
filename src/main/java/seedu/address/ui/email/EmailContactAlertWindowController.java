package seedu.address.ui.email;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmailContactAlertWindowController {

    private Stage stage;

    @FXML
    private Label AlertMessage;

    @FXML
    private Button OkButton;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == OkButton) {
            stage.close();
        }
    }

    void initData(Stage stage) {
        this.stage = stage;
        String alertMessage = "Please key in valid INTEGER number within range.";
        AlertMessage.setText(alertMessage);
    }
}
