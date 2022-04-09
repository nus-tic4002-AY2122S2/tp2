package seedu.address.ui.email;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmailContactNumberAlert {
    public final Stage emailWindowStage;
    public final Stage previousStage;
    private final Scene scene;
    private FXMLLoader loader;

    /**
     * Construct a new EmailContactNumberAlert
     * @param previousStage Stage of previous window
     */
    public EmailContactNumberAlert(Stage previousStage) {
        this.previousStage = previousStage;
        this.emailWindowStage = new Stage();
        try {
            this.loader = new FXMLLoader(getClass().getResource("/view/EmailContactNumberAlert.fxml"));
            scene = new Scene(this.loader.load());
            emailWindowStage.setTitle("Choosing Contact Number Alert.");
            emailWindowStage.setScene(scene);
            EmailContactAlertWindowController controller = loader.getController();
            controller.initData(emailWindowStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        emailWindowStage.show();
    }
}
