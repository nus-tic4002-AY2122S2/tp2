package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Restores the previous address book state from its history
 */
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ":  Restores the previous address book state from its history.\n Example: "
        + COMMAND_WORD;

    public static final String UNDO_COMMAND_SUCCESS = "Successfully restored previous address book state.";
    public static final String UNDO_COMMAND_FAILED = "No previous address book state to restore.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (model.undoAddressBook()) {
            return new CommandResult(UNDO_COMMAND_SUCCESS);
        }

        throw new CommandException(UNDO_COMMAND_FAILED);
    }
}
