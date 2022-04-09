package seedu.address.ui.email;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
            this.scene = new Scene(loader.load());
        } catch (IOException e) {
            System.out.println("Cannot out email alert window.");
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
