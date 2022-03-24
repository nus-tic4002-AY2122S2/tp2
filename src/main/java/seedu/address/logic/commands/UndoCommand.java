package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.LogicManager;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;

/**
 * Undo the most recent create or delete command.
 */
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Undo the most recent create or delete command.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXCOMMAND_IS_UNDO = "Cannot undo an 'undo' command.";
    public static final String MESSAGE_INVALID = "OOPS!!! I'm sorry, but I don't know what that means.";

    public static final String MESSAGE_UNDO_SUCCESS = "Successfully undo!";

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook,
                                    String exCommand) throws CommandException, ParseException {
        requireNonNull(model);

        if (exCommand.contains("undo")) {
            throw new CommandException(MESSAGE_EXCOMMAND_IS_UNDO);
        } else if (exCommand.contains("list") || exCommand.toLowerCase().contains("find")
                    || exCommand.toLowerCase().contains("help") || exCommand.toLowerCase().contains("filter")
                    || exCommand.toLowerCase().contains("copy") || exCommand.contains("bday")
                    || exCommand.contains("relate")) {
            return LogicManager.getResponse(exCommand);
        } else if (exCommand.contains("delete") || exCommand.contains("clear") || exCommand.contains("edit")
                    || exCommand.contains("rename")) {
            model.setAddressBook(originalAddressBook);
        } else if (exCommand.contains("add")) {
            Index index = ParserUtil.parseIndex(String.valueOf(model.getFilteredPersonList().size()));
            return new DeleteCommand(index).execute(model, originalAddressBook, exCommand);
        } else {
            throw new CommandException(MESSAGE_INVALID);
        }

        return new CommandResult(MESSAGE_UNDO_SUCCESS);
    }
}
