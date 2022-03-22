package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsMonthPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public NameContainsMonthPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsMonth(person.getBirthday().toString(), keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsMonthPredicate // instanceof handles nulls
                && keywords.equals(((NameContainsMonthPredicate) other).keywords)); // state check
    }

}
