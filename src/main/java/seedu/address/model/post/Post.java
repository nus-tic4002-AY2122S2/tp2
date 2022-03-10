package seedu.address.model.post;

import java.util.Objects;

public class Post {

    private final Title title;
    private final Content content;
    private final PostDate postDate;

    private final Category category;
    private final Notes notes;

    /**
     * Constructor to create a Post
     */
    public Post(Title title, Content content, PostDate postDate, Category category, Notes notes) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.category = category;
        this.notes = notes;
    }

    public Title getTitle() {
        return title;
    }

    public Content getContent() {
        return content;
    }

    public PostDate getPostDate() {
        return postDate;
    }

    public Category getCategory() {
        return category;
    }

    public Notes getNotes() {
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
