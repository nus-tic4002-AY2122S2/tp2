package seedu.address.ui.email;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmailSendSuccessfulWindow {
    public final Stage emailSendSuccessfulAlertWindowStage;
    private Scene scene;
    private FXMLLoader loader;

    /**
     * Creates a {@code EmailSendSuccessfulWindow}
     */
    public EmailSendSuccessfulWindow() {
        this.emailSendSuccessfulAlertWindowStage = new Stage();

        try {
            this.loader = new FXMLLoader(getClass().getResource("/view/EmailSentSuccessfulWindow.fxml"));
            this.scene = new Scene(this.loader.load());
        } catch (IOException e) {

        }

        emailSendSuccessfulAlertWindowStage.setTitle("Email Sent Successful");
        emailSendSuccessfulAlertWindowStage.setScene(scene);
        EmailSendSuccessfulWindowController controller = loader.getController();
        controller.initData(emailSendSuccessfulAlertWindowStage);
    }

    /**
     * Showes the email window
     */
    public void show() {
        emailSendSuccessfulAlertWindowStage.show();
    }
}
