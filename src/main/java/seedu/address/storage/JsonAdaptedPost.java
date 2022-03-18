package seedu.address.storage;

import java.util.Collections;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.post.Post;
import seedu.address.model.tag.Tag;

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
        title = source.getTitle().getValue();
        content = source.getContent().value;
        postDate = source.getPostDate().value;
        category = source.getCategory().value;
        notes = source.getNotes().tagName;
    }

    /**
     * Converts this Jackson-friendly adapted post object into the model's {@code Post} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted post.
     */
    public Post toModelType() throws IllegalValueException {
        final Name modelTitle = new Name(title);
        final Phone modelPostdate = new Phone(postDate);
        final Email modelContent = new Email(content);
        final Address modelCategory = new Address(category);
        final Tag modelNotes = new Tag(notes);
        return new Post(modelTitle, modelPostdate, modelContent, modelCategory, Collections.singleton(modelNotes));

    }

}
