package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.CliSyntax;
import seedu.address.testutil.PersonBuilder;

public class PersonDetailsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        PersonDetailsPredicate firstPredicate = new PersonDetailsPredicate(firstPredicateKeywordList);
        PersonDetailsPredicate secondPredicate = new PersonDetailsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        PersonDetailsPredicate firstPredicateCopy = new PersonDetailsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        PersonDetailsPredicate predicate =
                new PersonDetailsPredicate(Arrays.asList(CliSyntax.PREFIX_NAME.getPrefix(), "Alice"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Multiple keywords
        predicate = new PersonDetailsPredicate(Arrays.asList(CliSyntax.PREFIX_NAME.getPrefix(),
                "Alice", CliSyntax.PREFIX_NAME.getPrefix(), "Bob"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Only one matching keyword
        predicate = new PersonDetailsPredicate(Arrays.asList(CliSyntax.PREFIX_NAME.getPrefix(), "Bob",
                CliSyntax.PREFIX_NAME.getPrefix(), "Carol"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new PersonDetailsPredicate(Arrays.asList(CliSyntax.PREFIX_NAME.getPrefix(), "aLIce",
                CliSyntax.PREFIX_NAME.getPrefix(), "bOB"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        PersonDetailsPredicate predicate = new PersonDetailsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").build()));

        // Non-matching keyword
        predicate = new PersonDetailsPredicate(Arrays.asList(CliSyntax.PREFIX_NAME.getPrefix(), "Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Keywords match phone, email and address, but does not match name
        predicate = new PersonDetailsPredicate(Arrays.asList("12345", "alice@email.com", "Main", "Street"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));
    }
}
