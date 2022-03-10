package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents money owed to a Person in the address book.
 */
public class Money {
    public static final String MESSAGE_CONSTRAINTS = "Money should be decimals";
    public static final String VALIDATION_REGEX = "\\d+\\.\\d+";
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
}
