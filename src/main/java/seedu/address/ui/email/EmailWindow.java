package seedu.address.ui.email;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmailWindow {
    public final Stage emailWindow;
    private final Scene scene;

    public EmailWindow() {

        this.emailWindow = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/emailWindow.fxml"));
            scene = new Scene(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        emailWindow.setTitle("Email Window");
        emailWindow.setScene(scene);
    }
}
