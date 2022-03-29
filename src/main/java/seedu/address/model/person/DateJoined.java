package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class DateJoined {
    public final String value;
    public static final String MESSAGE_CONSTRAINTS = "Only accept valid date in dd/mm/yyyy format";
    public static final String VALIDATION_REGEX = "^(((([1-9])|([0-2][0-9])|(3[01]))[\\/]((0[13578])|([13578])|(1[02])))|((([1-9])|([0-2][0-9])|(30))[\\/]((0[469])|([469])|(11)))|((([1-9])|([0-2][0-9]))[\\/](2|02)))[\\/]\\d{4}$|^\\d{4}$";

    /**
     * Constructs an {@code dateJoined}.
     *
     * @param dateJoined
     */
    public DateJoined(String dateJoined) {
        requireNonNull(dateJoined);
        checkArgument(isValidDateJoined(dateJoined), MESSAGE_CONSTRAINTS);
        value = dateJoined;
    }

    /**
     * Returns if a given string is a valid email.
     */
    public static boolean isValidDateJoined(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateJoined // instanceof handles nulls
                && value.equals(((DateJoined) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
