package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.GreatBook;
import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "GreatBook has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAddressBook(new GreatBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
