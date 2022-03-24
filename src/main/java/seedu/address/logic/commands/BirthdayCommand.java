package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.NameContainsMonthPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class BirthdayCommand extends Command {

    public static final String COMMAND_WORD = "bday";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Display all persons whose birthday within "
            + "the specified month and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " 01";

    private final NameContainsMonthPredicate predicate;

    public BirthdayCommand(NameContainsMonthPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook,
                                    String exCommand) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BirthdayCommand // instanceof handles nulls
                && predicate.equals(((BirthdayCommand) other).predicate)); // state check
    }
}
