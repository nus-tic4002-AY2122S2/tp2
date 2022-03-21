package seedu.address.ui.email;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmailWindow {
    public final Stage emailWindowStage;
    private final Scene scene;
    private FXMLLoader loader;

    public EmailWindow(String from, String to) {

        this.emailWindowStage = new Stage();

        try {
            this.loader = new FXMLLoader(getClass().getResource("/view/emailWindow.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("/view/emailWindow.fxml"));
            scene = new Scene(this.loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        emailWindowStage.setTitle("Email Window");
        emailWindowStage.setScene(scene);
        EmailWindowController controller = loader.getController();
        controller.initData(from, to);
    }

    public void show() {
        emailWindowStage.show();
    }
}
