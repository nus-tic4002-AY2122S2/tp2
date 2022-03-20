package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;

public class EmailCommand extends Command {

    private static ObservableList<Person> personList;

    public static final String COMMAND_WORD = "email";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Send email to specific person.\n"
            + "Parameter: KEYWORD\n"
            + "Example: " + COMMAND_WORD + " Mich";

    private final NameContainsKeywordsPredicate predicate;

    public EmailCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        requireNonNull(model);
        model.updateFilteredPersonList(predicate);

        personList = model.getFilteredPersonList();

        if (personList.size() == 0) {
            throw new CommandException(Messages.MESSAGE_INVALID_COMMAND_FORMAT);
        }

        return new CommandResult("Person found.", true);
    }
}
