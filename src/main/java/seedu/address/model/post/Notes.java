package seedu.address.model.post;

public class Notes {
    public final String value;

    /**
     * Constructs a {@code Notes}.
     *
     * @param notes A valid notes.
     */
    public Notes(String notes) {
        this.value = notes;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Notes // instanceof handles nulls
                && value.equals(((Notes) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
