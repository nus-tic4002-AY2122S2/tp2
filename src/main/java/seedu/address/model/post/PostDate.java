package seedu.address.model.post;

public class PostDate {
    public final String value;

    /**
     * Constructs a {@code PostDate}.
     *
     * @param postDate A valid postDate.
     */
    public PostDate(String postDate) {
        this.value = postDate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostDate // instanceof handles nulls
                && value.equals(((PostDate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
