package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents money owed to a Person in the address book.
 */
public class Money {
    private final double value;

    /**
     * Constructs a {@code Money}.
     *
     * @param value A value.
     */
    public Money(double value) {
        requireNonNull(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
