package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class OverviewPanel extends UiPart<Region> {
    private static final String FXML = "OverviewPanel.fxml";

    @FXML
    private Label totalMoney;

    public OverviewPanel() {
        super(FXML);
    }
}
