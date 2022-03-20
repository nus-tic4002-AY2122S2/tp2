package seedu.address;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */
public class LoginController {

    @FXML // fx:id="button"
    private Button button; // Value injected by FXMLLoader

    @FXML // fx:id="resetButton"
    private Button resetButton; // Value injected by FXMLLoader

    @FXML // fx:id="textPasswd"
    private PasswordField textPasswd; // Value injected by FXMLLoader

    @FXML // fx:id="textUsername"
    private TextField textUsername; // Value injected by FXMLLoader

    @FXML
    private Label wrongLogin;

    @FXML
    void handleButtonAction(ActionEvent event) {

        if (event.getSource() == button) {
            String username = textUsername.getText().trim();
            String password = textPasswd.getText().trim();

            if (username.equals("Java") && password.equals("123456")) {
                Stage appStage = (Stage) button.getScene().getWindow();
                wrongLogin.setText("");
                textUsername.clear();
                textPasswd.clear();
                appStage.close();
                MainApp.appStage.show();
            } else if (username.isEmpty() && password.isEmpty()) {
                wrongLogin.setText("Please enter your User Login data");
            } else {
                wrongLogin.setText("Wrong username or password combination");
            }
        }

        if (event.getSource() == resetButton) {
            textUsername.setText("");
            textPasswd.setText("");
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'Login.fxml'.";
        assert textPasswd != null : "fx:id=\"textPasswd\" was not injected: check your FXML file 'Login.fxml'.";
        assert textUsername != null : "fx:id=\"textUsername\" was not injected: check your FXML file 'Login.fxml'.";
    }
}
