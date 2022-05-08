package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Restores a previously undone address book state from its history.
 */
public class RevertCommand extends Command {

    public static final String COMMAND_WORD = "revert";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ":  Reverts a previously reverted address book state from its history.\n Example: "
            + COMMAND_WORD;

    public static final String REDO_COMMAND_SUCCESS = "Successfully restored previously undone address book state.";
    public static final String REDO_COMMAND_FAILED = "No previous address book state to restore.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (model.redoAddressBook()) {
            return new CommandResult(REDO_COMMAND_SUCCESS);
        }

        throw new CommandException(REDO_COMMAND_FAILED);
    }
}