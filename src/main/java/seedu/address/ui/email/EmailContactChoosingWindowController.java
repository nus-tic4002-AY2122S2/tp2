package seedu.address.ui.email;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmailContactChoosingWindowController {

    @FXML
    private Button CancelButton;

    @FXML
    private Label ContactList;

    @FXML
    private Button OKButton;

    @FXML
    private TextField UserInputTxt;

    public void initial(ObservableList contactInfo) {

    }
}
