package seedu.address.ui.email;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmailSendSuccessfulWindowController {

    Stage stage;

    @FXML
    private Button closeButton;

    @FXML
    private Label info;

    @FXML
    void handleCloseButtonAction() {
        stage.close();
    }

    void initData(Stage stage) {
        String successfulInfo = "Email Sent Successful.";
        info.setText(successfulInfo);
        this.stage = stage;
    }
}
