package seedu.address.model.person;

import static seedu.address.logic.parser.CliSyntax.PREFIX_MONEY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;


/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class PersonDetailsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public PersonDetailsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }



    @Override
    public boolean test(Person person) {
        ArrayList<Boolean> matches = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            String currKeyword = keywords.get(i);
            String toFindStr;
            String context = "";
            Boolean isMoneyPrefix = currKeyword.equals(PREFIX_MONEY.getPrefix());
            Boolean isNamePrefix = currKeyword.equals(PREFIX_NAME.getPrefix());
            Boolean isTagPrefix = currKeyword.equals(PREFIX_TAG.getPrefix());
            if (isMoneyPrefix || isNamePrefix || isTagPrefix) {
                if (isMoneyPrefix) {
                    //just assume if you are looking for this tag, you are looking for people who owe you money. (m > 0)
                    matches.add((person.getMoney().getValue() > 0));
                } else {
                    i += 1; //loop will plus one more later
                    toFindStr = keywords.get(i);
                    if (isNamePrefix) {
                        context = person.getName().fullName;
                    }
                    if (isTagPrefix) {
                        var tags = person.getTags();
                        String flattenedTags = "";
                        for (var tag:tags) {
                            flattenedTags += (tag.tagName + " ");
                        }
                        context = flattenedTags;
                    }
                    final String ctx = context;
                    matches.add(StringUtil.containsWordIgnoreCase(ctx, toFindStr));
                }
            }
        }
        return matches.contains(true);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonDetailsPredicate // instanceof handles nulls
                && keywords.equals(((PersonDetailsPredicate) other).keywords)); // state check
    }
}
