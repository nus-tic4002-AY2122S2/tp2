package seedu.address.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class OverviewPanel extends UiPart<Region> implements PropertyChangeListener {
    private static final String FXML = "OverviewPanel.fxml";

    @FXML
    private Label totalMoney;

    public OverviewPanel() {
        super(FXML);
    }

    public void initZeroMoney() {
        totalMoney.setText("Total money owed: $0.0");
    }

    public void propertyChange(PropertyChangeEvent pce) {
        totalMoney.setText("Money owed: $" + (double) pce.getNewValue());
    }
}
