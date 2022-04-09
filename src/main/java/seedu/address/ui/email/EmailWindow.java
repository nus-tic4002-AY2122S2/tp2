package seedu.address.ui.email;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmailWindow {
    public final Stage emailWindowStage;
    private final Scene scene;
    private FXMLLoader loader;

    /**
     * Creates a {@code EmailWindow} with the given parameters:
     * @param from is the sender email address
     * @param password is the sender email address's password
     * @param to is the receiver's email address
     */
    public EmailWindow(String from, String password, String to) {

        this.emailWindowStage = new Stage();

        try {
            this.loader = new FXMLLoader(getClass().getResource("/view/emailWindow.fxml"));
            scene = new Scene(this.loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        emailWindowStage.setTitle("Email Window");
        emailWindowStage.setScene(scene);
        EmailWindowController controller = loader.getController();
        controller.initData(from, password, to, emailWindowStage);
    }

    /**
     * Show the email window
     */
    public void show() {
        emailWindowStage.show();
    }
}
