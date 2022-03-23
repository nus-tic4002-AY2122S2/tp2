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
    @FXML
    private Label contactCount;

    public OverviewPanel() {
        super(FXML);
    }

    public void initZeroMoney() {
        totalMoney.setText("Money owed: $0.0");
    }

    public void initZeroContactsCount() {
        contactCount.setText(" from 0 contacts");
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals("totalMoney")) {
            totalMoney.setText("Money owed: $" + pce.getNewValue());
        }
        if (pce.getPropertyName().equals("contactsWithMoneyCount")) {
            contactCount.setText(" from " + pce.getNewValue() + " contacts");
        }
    }
}
