package seedu.address.model.post;

public class Content {

    public final String value;

    /**
     * Constructs a {@code Content}.
     *
     * @param content A valid content.
     */
    public Content(String content) {
        this.value = content;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Content // instanceof handles nulls
                && value.equals(((Content) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


}
