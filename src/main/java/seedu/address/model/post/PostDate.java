package seedu.address.model.post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostDate {
    public final LocalDateTime value;

    /**
     * Constructs a {@code PostDate}.
     *
     * @param postDate A valid postDate.
     */
    public PostDate(LocalDateTime postDate) {
        this.value = postDate;
    }

    @Override
    public String toString() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostDate // instanceof handles nulls
                && value.equals(((PostDate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
