package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.post.Category;
import seedu.address.model.post.Content;
import seedu.address.model.post.Notes;
import seedu.address.model.post.Post;
import seedu.address.model.post.PostDate;
import seedu.address.model.post.Title;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class JsonAdaptedPost {

    private final String title;
    private final String content;
    private final String postDate;
    private final String category;
    private final String notes;
    private final List<String> sentCid = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPost} with the given post details.
     */
    @JsonCreator
    public JsonAdaptedPost(@JsonProperty("title") String title, @JsonProperty("content") String content,
                           @JsonProperty("postdate") String postDate, @JsonProperty("category") String category,
                           @JsonProperty("notes") String notes,
                           @JsonProperty("sentCid") List<String> sentCid) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.category = category;
        this.notes = notes;
        if(sentCid != null) {
            this.sentCid.addAll(sentCid);
        }
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
        sentCid.addAll(source.getSentCid().stream().collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted post object into the model's {@code Post} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted post.
     */
    public Post toModelType() throws IllegalValueException {
        final List<String> postSentCid = new ArrayList<>();
        postSentCid.addAll(sentCid);
        final Title modelTitle = new Title(title);
        final Content modelContent = new Content(content);
        final PostDate modelPostdate = new PostDate(postDate);
        final Category modelCategory = new Category(category);
        final Notes modelNotes = new Notes(notes);

        final Set<String> modelSentCid = new HashSet<>(postSentCid);
        return new Post(modelTitle, modelContent, modelPostdate, modelCategory, modelNotes, modelSentCid);

    }

}
