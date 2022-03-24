package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents money owed to a Person in the address book.
 */
public class Money {
    public static final String MESSAGE_CONSTRAINTS =
            "Money should be decimals up to 2dp, non-negative and less than 1,000,000.99";
    public static final String VALIDATION_REGEX = "\\d{1,7}\\.\\d{1,2}";
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

    public double getValue() {
        return value;
    }

    /**
     * Returns true if a given string is a valid money.
     */
    public static boolean isValidMoney(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Money // instanceof handles nulls
                && (value == ((Money) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
