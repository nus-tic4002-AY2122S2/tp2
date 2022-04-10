package seedu.address.ui.email;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.model.person.Person;

public class EmailContactChoose {
    public final Stage stage;
    private final Scene scene;
    private FXMLLoader loader;

    /**
     * Create a new EmailContactChoose
     * @param contactInfo all the matched contact info
     */
    public EmailContactChoose(ObservableList<Person> contactInfo) {
        this.stage = new Stage();

        try {
            this.loader = new FXMLLoader(getClass().getResource("/view/EmailContactChoosingWindow.fxml"));
            scene = new Scene(this.loader.load());
        } catch (IOException e) {
            //System.out.println("Cannot Load Contact Choose Window.");
            throw new RuntimeException(e);
        }

        this.stage.setTitle("Contact Choose Window");
        this.stage.setScene(scene);
        EmailContactChoosingWindowController controller = loader.getController();
        controller.initial(contactInfo, stage, "tic4003tp5@gmail.com", "nusyear4");
    }

    /**
     * Show the contact choosing for email window
     */
    public void show() {
        this.stage.show();
    }
}
