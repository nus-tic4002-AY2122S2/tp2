package seedu.address.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonGridPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);
    private ObservableList<Node> nodes;
    private ObservableList<Person> personList;

    // @FXML
    // private ListView<Person> personListView;

    @FXML
    private FlowPane flowPane;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);
        // personListView.setItems(personList);
        // personListView.setCellFactory(listView -> new PersonListViewCell());
        this.personList = personList;
        nodes = flowPane.getChildren();
        personList.addListener(this::listListener);
        rebuildAllNodes();
        // int i = 1;
        // for (Person person : personList) {
        //     flowPane.getChildren().add(new PersonCard(person, i++).getRoot());
        // }

    }

    private List<Node> buildNodesFor(List<? extends Person> personList) {
        ArrayList<Node> newNodes = new ArrayList<>(personList.size());
        for (Person person : personList) {
            Node node = buildNodeFor(person);
            newNodes.add(node);
        }
        return newNodes;
    }

    protected Node buildNodeFor(Person person) {
        return new PersonCard(person, personList.indexOf(person) + 1).getRoot();
    }


    private void rebuildAllNodes() {
        List<Node> newNodes = buildNodesFor(personList);
        nodes.setAll(newNodes);
    }

    private void listListener(ListChangeListener.Change<? extends Person> l) {
        rebuildAllNodes();
    }

    private void updateItem() {

    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}
