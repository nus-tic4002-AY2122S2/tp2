package seedu.address.ui.email;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmailSendFailAlertWindowController {

    private Stage stage;

    @FXML
    private Label alertInfo;

    @FXML
    private Label suggestionLabel;

    @FXML
    private Button okButton;

    @FXML
    void handleButtonAction(ActionEvent event) {

        if (event.getSource() == okButton) {
            stage.close();
        }
    }

    public void initData(Stage stage) {
        this.stage = stage;
        alertInfo.setText("Email Failed.");
        suggestionLabel.setText("Please key in valid input and correct setting");
    }

    public void show() {
        this.stage.show();
    }
}
