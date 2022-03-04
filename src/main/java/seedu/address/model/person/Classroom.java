package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidClassroom(String)} (String)}
 */
public class Classroom {


    public static final String MESSAGE_CONSTRAINTS =
            "Classroom should be in the format 1A, 1B, 1C, 2A, 2B, 2C etc";
//    public static final String VALIDATION_REGEX = "\\d{3,}";
    public final String value;

    /**
     * Constructs a {@code Phone}.
     *
     * @param classroom A valid classroom .
     */
    public Classroom(String classroom) {
        requireNonNull(classroom);
        checkArgument(isValidClassroom(classroom), MESSAGE_CONSTRAINTS);
        value = classroom;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidClassroom(String test) {
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Classroom // instanceof handles nulls
                && value.equals(((Classroom) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
