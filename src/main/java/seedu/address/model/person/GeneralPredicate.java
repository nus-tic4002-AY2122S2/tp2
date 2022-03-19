package seedu.address.model.person;

import java.util.List;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class GeneralPredicate extends TagPredicate {
    private final List<String> keywords;

    public GeneralPredicate(List<String> keywords) {
        super(keywords);
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        boolean nameMatch = keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword));
        return nameMatch || super.test(person);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GeneralPredicate // instanceof handles nulls
                && keywords.equals(((GeneralPredicate) other).keywords)); // state check
    }

}
