package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.post.Post;


/**
 * A UI component that displays information of a {@code Post}.
 */
public class PostCard extends UiPart<Region> {

    private static final String FXML = "PostListCard.fxml";

    public final Post post;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label title;
    @FXML
    private Label content;
    @FXML
    private Label postdate;
    @FXML
    private Label category;
    @FXML
    private Label notes;


    /**
     * Creates a {@code PostCard} with the given {@code Post} and index to display.
     */
    public PostCard(Post post, int displayedIndex) {
        super(FXML);
        this.post = post;
        id.setText(displayedIndex + ". ");
        title.setText(post.getTitle().value);
        content.setText(post.getContent().value);
        postdate.setText(post.getPostDate().value);
        category.setText(post.getCategory().value);
        notes.setText(post.getNotes().value + post.getSentCid().toString());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PostCard)) {
            return false;
        }

        // state check
        PostCard card = (PostCard) other;
        return id.getText().equals(card.id.getText())
                && post.equals(card.post);
    }
}
