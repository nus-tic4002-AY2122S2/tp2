package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

public class EmailWindow extends UiPart<Stage> {
    private static final String FXML = "EmailWindow.fxml";
    private static final Logger logger = LogsCenter.getLogger(EmailWindow.class);

    @FXML
    private Button sendButton;

    @FXML
    private Label fromEmailAddress;

    @FXML
    private Label toEmailAddress;

    @FXML
    private TextField emailSubject;

    @FXML
    private TextArea emailContent;

    /**
     * Creates a new HelpWindow.
     */
    public EmailWindow(Stage root) {
        super(FXML, root);
    }

    /**
     * Creates a new HelpWindow.
     */
    public EmailWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     */
    public void show() {
        logger.info("Showing email window.");
        getRoot().show();
        getRoot().centerOnScreen();
    }
}
