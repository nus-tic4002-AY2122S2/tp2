package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Lists all persons that has been favourite
 */
public class ListFavCommand extends Command {

    public static final String COMMAND_WORD = "listfav";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": List all persons whose has been favourite "
            + "by the user and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_NO_CONTACT = "Listed all persons who been favourite (but you do not have "
            + "any contacts favourite)";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(getFavouritePredicate());
        if (model.getFilteredPersonList().size() == 0) {
            return new CommandResult(MESSAGE_NO_CONTACT);
        }
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    public Predicate<Person> getFavouritePredicate() {
        return i -> i.getFavourite().getBoolean();
    }


}
