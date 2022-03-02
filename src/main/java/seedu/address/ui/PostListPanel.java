package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.post.Post;

import javafx.scene.layout.Region;
import javafx.scene.control.ListView;
import java.util.logging.Logger;

public class PostListPanel extends UiPart<Region> {
    private static final String FXML = "PostListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PostListPanel.class);

    @FXML
    private ListView<Post> postListView;

    /**
     * Creates a {@code PostListPanel} with the given {@code ObservableList}.
     */
    public PostListPanel(ObservableList<Post> postList) {
        super(FXML);
        postListView.setItems(postList);
        postListView.setCellFactory(listView -> new PostListPanel.PostListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Post} using a {@code PostCard}.
     */
    class PostListViewCell extends ListCell<Post> {
        @Override
        protected void updateItem(Post post, boolean empty) {
            super.updateItem(post, empty);

            if (empty || post == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PostCard(post, getIndex() + 1).getRoot());
            }
        }
    }


}
