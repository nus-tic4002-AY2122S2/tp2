package seedu.address.model.person;

import static java.util.Objects.requireNonNull;


public class Birthday {

    public static final String MESSAGE_CONSTRAINTS =
            "Birthdays should only contain , and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code Name}.
     *
     * @param birthDay A valid name.
     */
    public Birthday(String birthDay) {
        requireNonNull(birthDay);
//        checkArgument(isValidName(birthDay), MESSAGE_CONSTRAINTS);
        value = birthDay;
    }

    /**
     * Returns true if a given string is a valid name.
     */
//    public static boolean isValidName(String test) {
//        return test.matches(VALIDATION_REGEX);
//    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && value.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
