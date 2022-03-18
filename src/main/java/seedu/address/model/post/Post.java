package seedu.address.model.post;

import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

public class Post {

    private final Name title;
    private final Email content;
    private final Phone postDate;

    private final Address category;
    private final Tag notes;

    /**
     * Constructor to create a Post
     */
    public Post(Name name, Phone phone, Email email, Address address, Set<Tag> tagList) {
        this.title = name;
        this.content = email;
        this.postDate = phone;
        this.category = address;
        this.notes = (Tag) tagList;
    }

    public Name getTitle() {
        return title;
    }

    public Email getContent() {
        return content;
    }

    public Phone getPostDate() {
        return postDate;
    }

    public Address getCategory() {
        return category;
    }
    public Tag getNotes() {
        return notes;
    }

    /**
     * Returns true if both posts have the same title.
     * This defines a weaker notion of equality between two posts.
     */
    public boolean isSamePost(Post otherPost) {
        if (otherPost == this) {
            return true;
        }

        return otherPost != null
                && otherPost.getTitle().equals(getTitle());
    }

    /**
     * Returns true if both posts have the same identity and data fields.
     * This defines a stronger notion of equality between two posts.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Post)) {
            return false;
        }

        Post otherPost = (Post) other;
        return otherPost.getTitle().equals(getTitle())
                && otherPost.getContent().equals(getContent())
                && otherPost.getPostDate().equals(getPostDate())
                && otherPost.getCategory().equals(getCategory())
                && otherPost.getNotes().equals(getNotes());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, content, postDate, category, notes);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append("; Content: ")
                .append(getContent())
                .append("; PostDate: ")
                .append(getPostDate())
                .append("; Category: ")
                .append(getCategory())
                .append("; Notes: ")
                .append(getNotes());
        return builder.toString();
    }
}
