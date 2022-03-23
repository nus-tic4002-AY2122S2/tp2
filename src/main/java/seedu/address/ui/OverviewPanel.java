package seedu.address.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class OverviewPanel extends UiPart<Region> implements PropertyChangeListener {
    private static final String FXML = "OverviewPanel.fxml";
    private static final String MONEY_PREFIX = "Owed $";
    private static final String CONTACTS_COUNT_PREFIX = " to ";
    private static final String CONTACTS_COUNT_SUFFIX = " contacts";

    @FXML
    private Label totalMoney;
    @FXML
    private Label contactCount;

    public OverviewPanel() {
        super(FXML);
    }

    public void initZeroMoney() {
        totalMoney.setText(MONEY_PREFIX + "0.0");
    }

    public void initZeroContactsCount() {
        contactCount.setText(CONTACTS_COUNT_PREFIX + "0" + CONTACTS_COUNT_SUFFIX);
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals("totalMoney")) {
            totalMoney.setText(MONEY_PREFIX + pce.getNewValue());
        }
        if (pce.getPropertyName().equals("contactsWithMoneyCount")) {
            contactCount.setText(CONTACTS_COUNT_PREFIX + pce.getNewValue() + CONTACTS_COUNT_SUFFIX);
        }
    }
}
