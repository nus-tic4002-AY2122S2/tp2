package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.post.Post;


public class JsonAdaptedPost {

    private final String title;
    private final String content;
    private final String postDate;
    private final String category;
    private final String notes;

    /**
     * Constructs a {@code JsonAdaptedPost} with the given post details.
     */
    @JsonCreator
    public JsonAdaptedPost(@JsonProperty("title") String title, @JsonProperty("content") String content,
                             @JsonProperty("postdate") String postDate, @JsonProperty("category") String category,
                           @JsonProperty("notes") String notes) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.category = category;
        this.notes = notes;
    }

    /**
     * Converts a given {@code Post} into this class for Jackson use.
     */
    public JsonAdaptedPost(Post source) {
        title = source.getTitle().value;
        content = source.getContent().value;
        postDate = source.getPostDate().value;
        category = source.getCategory().value;
        notes = source.getNotes().value;
    }

}
