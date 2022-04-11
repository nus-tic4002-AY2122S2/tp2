package seedu.address.ui.email;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmailSendFailAlertWindow {
    public final Stage stage;
    private final Scene scene;
    private FXMLLoader loader;

    /**
     * Constructor
     */
    public EmailSendFailAlertWindow() {
        this.stage = new Stage();

        try {
            this.loader = new FXMLLoader(getClass().getResource("/view/EmailSendFailAlertWindow.fxml"));
            scene = new Scene(this.loader.load());
            stage.setTitle("Email Failed.");
            stage.setScene(scene);
            EmailSendFailAlertWindowController controller = loader.getController();
            controller.initData(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        this.stage.show();
    }
}
