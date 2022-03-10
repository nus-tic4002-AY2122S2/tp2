package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents money owed to a Person in the address book.
 */
public class Money {
    private final float value;

    /**
     * Constructs a {@code Money}.
     *
     * @param value A value.
     */
    public Money(float value) {
        requireNonNull(value);
        this.value = value;
    }
}
