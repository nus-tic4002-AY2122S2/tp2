package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class English {
    public static final String MESSAGE_CONSTRAINTS = "Score should be integer between 0 to 100";

    public final int score;

    public static boolean isValidScore(int value) {
        if (value >= 0 && value <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public English(int value) {
        requireNonNull(value);
        checkArgument(isValidScore(value), MESSAGE_CONSTRAINTS);
        score = value;
    }

    @Override
    public String toString() {
        return Integer.toString(score);
    }
}
