package seedu.address.model.post;

public class Category {

    public final String value;

    /**
     * Constructs a {@code Category}.
     *
     * @param category A valid category.
     */
    public Category(String category) {
        this.value = category;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Category // instanceof handles nulls
                && value.equals(((Category) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }



}
