package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidReceiveType(String)}
 */
public class ReceiveType {

    public static final String MESSAGE_CONSTRAINTS =
            "Receive Method can only be sms or email";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code ReceiveType}.
     *
     * @param type ether sms or email.
     */
    public ReceiveType(String type) {
        requireNonNull(type);
        checkArgument(isValidReceiveType(type), MESSAGE_CONSTRAINTS);
        value = type;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidReceiveType(String type) {
        type = type.trim();
        if (type.equals("sms") || type.equals("email")) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReceiveType // instanceof handles nulls
                && value.equals(((ReceiveType) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
