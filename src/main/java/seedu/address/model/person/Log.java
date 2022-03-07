package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
/**
 * Represents a Person's log in the address book.
 * Guarantees: immutable; is always valid
 */
public class Log {
    public final String value;

    /**
     * Log constructor
     * @param remark Brief logging update
     */
    public Log(String remark) {
        requireNonNull(remark);
        value = remark;
    }
    @Override
    public String toString() {
        return value;
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Log // instanceof handles nulls
                && value.equals(((Log) other).value)); // state check
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
