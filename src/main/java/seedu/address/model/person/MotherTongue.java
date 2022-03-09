package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Mother Tongue score.
 * Guarantees: immutable; is valid as declared in {@link #isValidScore(int)}
 */
public class MotherTongue {
    public static final String MESSAGE_CONSTRAINTS = "Score should be integer between 0 to 100";

    public final int score;

    /**
     * Constructs a {@code MotherTongue}.
     *
     * @param value A valid score.
     */
    public MotherTongue(int value) {
        requireNonNull(value);
        checkArgument(isValidScore(value), MESSAGE_CONSTRAINTS);
        score = value;
    }

    /**
     * Returns true if a given string is a valid score.
     */
    public static boolean isValidScore(int value) {
        if (value >= 0 && value <= 100) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(score);
    }
}
