package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_RELATE;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;


public class RelateCommand extends Command {

    public static final String COMMAND_WORD = "relate";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": 1 to n mutual relationship "
            + "by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_RELATE + " "
            + "[INDEX1] "
            + "[INDEX2] "
            + "[INDEX3]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_RELATE + "2 3 4 ";

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook
            originalAddressBook, String exCommand) throws CommandException,
            ParseException {
        return null;
    }
}
