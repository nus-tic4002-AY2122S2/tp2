package seedu.address.ui.email;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmailSendSuccessfulWindowController {

    private Stage stage;

    @FXML
    private Button closeButton;

    @FXML
    private Label info;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == closeButton) {
            stage.close();
        }
    }

    void initData(Stage stage) {
        String successfulInfo = "Email Sent Successful.";
        info.setText(successfulInfo);
        this.stage = stage;
    }
}
