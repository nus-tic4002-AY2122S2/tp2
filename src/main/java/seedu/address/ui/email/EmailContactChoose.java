package seedu.address.ui.email;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmailContactChoose {
    public Stage stage;

    public EmailContactChoose(ObservableList contactInfo) {
        this.stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EmailContactChoosingWindow.fxml"));
            Scene scene = new Scene(loader.load());
            this.stage.setTitle("Contact Choose Window");
            this.stage.setScene(scene);

            EmailContactChoosingWindowController controller = loader.getController();
            controller.initial(contactInfo);
        } catch (IOException e) {
            System.out.println("Cannot Load Contact Choose Window.");
        }
    }

    /**
     * Show the contact choosing for email window
     */
    public void show() {
        stage.show();
    }
}
