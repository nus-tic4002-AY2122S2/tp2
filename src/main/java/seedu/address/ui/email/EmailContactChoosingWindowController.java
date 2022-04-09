package seedu.address.ui.email;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seedu.address.model.person.Person;

public class EmailContactChoosingWindowController {

    ObservableList<Person> contactInfo;
    private int contactQuantity;
    private Stage stage;
    private String from;
    private String password;

    @FXML
    private Button CancelButton;

    @FXML
    private Label ContactList;

    @FXML
    private Button OKButton;

    @FXML
    private TextField UserInputTxt;

    @FXML
    void handleButtonAction(ActionEvent event) {

        if (event.getSource() == OKButton) {
            String inputNumberStr = UserInputTxt.getText();
            int inputNumberInt = Integer.parseInt(inputNumberStr);

            if (inputNumberInt > contactQuantity || inputNumberInt < 1) {
                //New error alert window to show;
                EmailContactNumberAlert emailContactNumberAlert = new EmailContactNumberAlert(stage);
                emailContactNumberAlert.show();
            } else {
                String to = contactInfo.get(inputNumberInt).getEmail().toString();
                //Open email form window
                EmailWindow emailWindow = new EmailWindow(from, password, to);
                emailWindow.show();
                stage.close();
            }
        } else if (event.getSource() == CancelButton) {
            stage.close();
        }
    }

    void initial(ObservableList<Person> contactInfo, Stage stage, String from, String password) {
        this.from = from;
        this.password = password;
        this.contactInfo = contactInfo;
        this.stage = stage;
        StringBuilder allContact = new StringBuilder();
        contactQuantity = contactInfo.size();

        for(int i=0; i<contactInfo.size(); i++) {
            int serialNumber = i+1;
            allContact.append(serialNumber).append(". ").append(contactInfo.get(i).getName()).append(": ").append(contactInfo.get(i).getEmail()).append("\n");
        }

        ContactList.setText(allContact.toString());
    }
}
