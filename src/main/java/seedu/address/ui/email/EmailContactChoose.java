package seedu.address.ui.email;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.model.person.Person;

import java.io.IOException;

public class EmailContactChoose {
    public final Stage stage;
    private final Scene scene;
    private FXMLLoader loader;

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
